package com.JCEX.utils;
 
import java.util.*;

import com.JCEX.pojo.ReplaceRegion;
import com.itextpdf.awt.geom.Rectangle2D.Float;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

/**
 * pdf渲染监听,当找到渲染的文本时，得到文本的坐标x,y,w,h
 */
public class PositionRenderListener implements RenderListener{
	
	private List<String> findText;
	private float defaultH;		///出现无法取到值的情况，默认为10
	private float fixHeight;	//可能出现无法完全覆盖的情况，提供修正的参数，默认为2
	public PositionRenderListener(List<String> findText, float defaultH,float fixHeight) {
		this.findText = findText;
		this.defaultH = defaultH;
		this.fixHeight = fixHeight;
	}
 
	public PositionRenderListener(List<String> findText) {
		this.findText = findText;
		this.defaultH = 10;
		this.fixHeight = 2;
	}
	
	@Override
	public void beginTextBlock() {
		
	}
 
	@Override
	public void endTextBlock() {
		
	}
 
	@Override
	public void renderImage(ImageRenderInfo imageInfo) {
	}

	private Map<String, ReplaceRegion> result = new HashMap<String, ReplaceRegion>();
    //里面存储着所有文本
	private StringBuffer textlist=new StringBuffer();
	//文本与对应的坐标
	public List<ReplaceRegion> TextAndCoordinate=new ArrayList<ReplaceRegion>();



	/**
	 * 取出所有文本及坐标
	 * @param textInfo
	 */
	@Override
	public void renderText(TextRenderInfo textInfo) {
		String text = textInfo.getText();
		textlist.append(text);
		Float bound = textInfo.getBaseline().getBoundingRectange();
		if(null != text){
				ReplaceRegion replaceRegion = new ReplaceRegion(text);
				replaceRegion.setAliasName(text);
				replaceRegion.setH(bound.height == 0 ? defaultH : bound.height);
				replaceRegion.setW(bound.width);
				replaceRegion.setX(bound.x);
				replaceRegion.setY(bound.y-this.fixHeight);
				TextAndCoordinate.add(replaceRegion);
		}
	}

	/**
	 * 关键词匹配规则 先单独匹配 如果单独匹配不到 再根据行匹配
	 * @return 返回存储替换或者修改的值及坐标
	 */
	public Map<String,List<ReplaceRegion>>  getResult() {
		System.out.println("textlist = " + textlist);
		Map<String,List<ReplaceRegion>> successOrFailedDate=new HashMap<String,List<ReplaceRegion>>();

		//存储匹配的临时行数据
		List<ReplaceRegion> interimRow=new ArrayList<ReplaceRegion>();
		//存储的完全匹配成功的文本及坐标
		List<ReplaceRegion> SuccessTextAndCoordinate=new ArrayList<ReplaceRegion>();
		//存储第几个已经匹配成功的关键词 已经匹配成功的将排除 避免过多的循环
		Map<String,Boolean> SuccessOrFailed=new HashedMap();
		int i=0;
		for(int findTextIndex=0;findTextIndex<findText.size();findTextIndex++){
			SuccessOrFailed.put(findText.get(findTextIndex),false);
		}
		//循环遍历所有的文本坐标 找到关键词的坐标
        start:for(int TextAndCoordinateIndex=0;TextAndCoordinateIndex<TextAndCoordinate.size();TextAndCoordinateIndex++){
			ReplaceRegion replaceRegion = TextAndCoordinate.get(TextAndCoordinateIndex);
			//匹配状态
			boolean status=false;

			//因为要匹配的文本是多个 所以要重复匹配多个文本 并且要把已经匹配成功的文本做标记
			other:for(int findTextIndex=0;findTextIndex<findText.size();findTextIndex++){

				//存储匹配的临时成功文本及坐标数据
				List<ReplaceRegion> interimTextAndCoordinate=new ArrayList<ReplaceRegion>();
				//一个关键词
				String text = findText.get(findTextIndex);
				if(text.equals(replaceRegion.getAliasName())){
					SuccessOrFailed.put(text,true);
					interimTextAndCoordinate.add(replaceRegion);
					successOrFailedDate.put(text,interimTextAndCoordinate);
				}
				//匹配成功的数据不需要再匹配第二次了
				Set<Map.Entry<String, Boolean>> entries = SuccessOrFailed.entrySet();
				for (Map.Entry<String, Boolean> successOrFailed:
				entries) {
                      if(successOrFailed.getKey().equals(text)){
                      	if(successOrFailed.getValue()){
                      		continue other;
						}
					  }
				}
				
				//因开发工具不同  myeclipse拆分的第一个索引是一个无用的空  所以要剔除第一个元素 idea是正常的
				String[] findtextSplit1 = text.split("");
				String[] findtextSplit=new String[findtextSplit1.length];
				for(int textindex=0;textindex<findtextSplit1.length;textindex++){
					if(StringUtils.isEmpty(findtextSplit1[0])){
						if(textindex+1==findtextSplit1.length){
							break;
						}
						findtextSplit[textindex]=findtextSplit1[textindex+1];
					}else{
						findtextSplit[textindex]=findtextSplit1[textindex];
					}
				}
				
				//只有成功匹配了第一个值才有必要匹配下一个值 否则将产生极大的性能浪费 可以根据自己的需求修改 也可以多匹配几个值
				if(replaceRegion.getAliasName().equals(findtextSplit[0])){
					//虽然要使用TextAndCoordinateIndex的索引  但是不能影响到TextAndCoordinateIndex的值
					// 保障匹配的准确度 因为不知道关键词字符会出现在第几个字符
					end:for(int MatchCoordinate=TextAndCoordinateIndex;TextAndCoordinateIndex<MatchCoordinate+findtextSplit.length-1;MatchCoordinate++){
						//myeclipse测试这里要减1 idea不用 否则会出现少匹配一个字符  服务器上跟idea保持一致
//						if(findtextSplit.length-1==i&&status==true){
						if(findtextSplit.length==i&&status==true){
							break end;
						}
						String aliasName = TextAndCoordinate.get(MatchCoordinate).getAliasName();
						if(aliasName.equals(findtextSplit[i])){
							status=true;
							//有匹配上的 进行临时保存
							
							interimTextAndCoordinate.add(TextAndCoordinate.get(MatchCoordinate));
							if(text.equals("07075281715")|text.equals("1-10-3")&&i>3){
								System.out.println(1);
							}
						}else{
							//下面的方法是按行匹配
							//判断当前的关键词包含空格
							if(text.contains(" ")){
								int text1 = text.indexOf(" ");
								if(interimTextAndCoordinate.size()>=text1){
									java.lang.Float y1 = interimTextAndCoordinate.get(interimTextAndCoordinate.size()-1).getY();
									java.lang.Float x1 = interimTextAndCoordinate.get(interimTextAndCoordinate.size()-1).getX();
                                    //把同一行里大于最后一个匹配成功的x坐标的文本及坐标全取出来
									for (ReplaceRegion r:
									TextAndCoordinate) {
										//只要是同一个Y轴的文本及坐标都要
										if(r.getY().equals(y1)){
											if(!StringUtils.isBlank(r.getAliasName())){
												interimRow.add(r);
											}
										}
									}
									//按照X坐标的升序排列 从小到大 以保障能正确的匹配以及可以正确的取到匹配成功的文本索引
									Collections.sort(interimRow, new Comparator<ReplaceRegion>() {
										@Override
										public int compare(ReplaceRegion user1, ReplaceRegion user2) {
											java.lang.Float id1 = user1.getX();
											java.lang.Float id2 = user2.getX();
											//可以按对象的其他属性排序，只要属性支持compareTo方法
											return id1.compareTo(id2);
										}
									});
									StringBuffer MatchRow=new StringBuffer();
									for (int j = 0; j < interimRow.size(); j++) {
										MatchRow.append(interimRow.get(j).getAliasName());
									}
									
									String endtext=text;
									for(;endtext.contains(" ");){
										endtext=endtext.replace(" ","");
									}

                                    if(MatchRow.toString().contains(text)||MatchRow.toString().contains(endtext)){
										int startIndex=0;
										int endIndex=0;
                                        if(MatchRow.toString().indexOf(text)!=-1){
											startIndex=MatchRow.toString().indexOf(text);
											endIndex=startIndex+text.length();
										}else if(MatchRow.toString().indexOf(endtext)!=-1){
											startIndex=MatchRow.toString().indexOf(endtext);
											endIndex=startIndex+endtext.length();
										}
										for (int j = startIndex; j < endIndex; j++) {
											interimTextAndCoordinate.add(interimRow.get(j));
											System.out.println("SuccessCoordinate.toString() = " + interimRow.get(j).toString());
										}
										successOrFailedDate.put(text,interimTextAndCoordinate);
										interimRow.clear();
										MatchRow=new StringBuffer();
										SuccessOrFailed.put(text,true);
										i=0;
										continue start;
									}else{
										MatchRow=new StringBuffer();
										interimRow.clear();
									}
								}
							}
							//如果到这有一个匹配不上 那就说明匹配失败 清除临时保存的文本及坐标 重置i索引 重新开始匹配
							interimTextAndCoordinate.clear();
							status=false;
							//重置i
							i=0;
							continue other;
						}
						i++;
					}
					//全部匹配成功
					if(status==true){
						//把已经成功匹配的做上标记 不用继续匹配了
						if(text.equals("07075281715")||text.equals("1-10-3")){
							System.out.println(412);
						}
						SuccessOrFailed.put(text,true);

						//把临时文本及坐标保存到成功的数据里去
						successOrFailedDate.put(text,interimTextAndCoordinate);
//						for (ReplaceRegion interimText:
//						interimTextAndCoordinate) {
//
//							SuccessTextAndCoordinate.add(interimText);
//						}
						//重置i 因为还需要重新匹配
						i=0;
						for (ReplaceRegion SuccessCoordinate:
							interimTextAndCoordinate) {
							System.out.println("SuccessCoordinate.toString() = " + SuccessCoordinate.toString());
						}
					}
				}else{
					continue other;
				}
			}
		}

		return successOrFailedDate;
	}
}
