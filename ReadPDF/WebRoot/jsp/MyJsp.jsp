<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
    
    <script type="text/javascript">
    
      
      function downloadtest(id){
		var url = "<%=request.getContextPath()%>/download?path=${requestScope.path}";
		$("#pluginurl").attr("href",url);
		}
	  function downZip(id){
		var url = "<%=request.getContextPath()%>/downZip?path=${requestScope.path}";
		$("#downzip").attr("href",url);
		}
		
	  function downCzZip(id){
		var url = "<%=request.getContextPath()%>/downSHZip?SHpath=${requestScope.SHpath}";
		$("#downCzzip").attr("href",url);
		}
	  <%-- function downDJ(id){
		var url = "<%=request.getContextPath()%>/downDJ?DJpath=${requestScope.DJpath}";
		$("#downDJ").attr("href",url);
		} --%>
	  function downB2C(id){
		var url = "<%=request.getContextPath()%>/downloadB2CExecl?B2Cpath=${requestScope.B2Cpath}";
		$("#downB2C").attr("href",url);
		}
		function downloadCanadaList(id){
		var url = "<%=request.getContextPath()%>/downloadCanadaList?CanadaListpath=${requestScope.DJpath}";
		$("#downloadCanadaList").attr("href",url);
		}
		
		function downPCA(id){
		var url = "<%=request.getContextPath()%>/downloadPCA?PCApath=${requestScope.PCApath}";
		$("#downPCA").attr("href",url);
		}
		function downEuropeanTaxBill(id){
		var url = "<%=request.getContextPath()%>/downloadEuropeanTaxBill?EuropeanTaxBillpath=${requestScope.EuropeanTaxBillpath}";
		$("#downEuropeanTaxBill").attr("href",url);
		}
		function downEMS(id){
		var url = "<%=request.getContextPath()%>/downloadEMS?EMSpath=${requestScope.EMSpath}";
		$("#downEMS").attr("href",url);
		}
		function downWish(id){
		var url = "<%=request.getContextPath()%>/downloadWish?Wishpath=${requestScope.Wishpath}";
		$("#downWish").attr("href",url);
		}
		function downMaBang(id){
		var url = "<%=request.getContextPath()%>/downloadMaBang?MaBangpath=${requestScope.MaBangpath}";
		$("#downMaBang").attr("href",url);
		}
		function downDeletePDFContentZip(id){
		var url = "<%=request.getContextPath()%>/downDeletePDFContentZip?downDeletePDFContentZippath=${requestScope.downDeletePDFContentZippath}";
		$("#downDeletePDFContentZip").attr("href",url);
		}
		function downLiXiaoFei(id){
		var url = "<%=request.getContextPath()%>/downloadLiXiaoFei?downloadLiXiaoFeipath=${requestScope.downloadLiXiaoFeipath}";
		$("#downLiXiaoFei").attr("href",url);
		}
		function downloadYaoYe(id){
		var url = "<%=request.getContextPath()%>/downloadYaoYe?YaoYepath=${requestScope.YaoYepath}";
		$("#downloadYaoYe").attr("href",url);
		}
		
		<%-- $().ready(function(){
			 var str='<%=request.getAttribute("DJpath")%>';
			 str=str.replace('[','');
			 str=str.replace(']','');
			 str=str.replace(' ','');
	         var arr = str.split(',');
			 /* alert(arr); */
			 var txt = "";
			 var err ="";
			 for(var i=0;i<arr.length;i++){  //循环LIST
                        //获取LIST里面的对象
                        var total=arr[i];
                       /*  alert(total); */
                        var totalindex=total.indexOf("......");
                        /* alert(totalindex); */
                        var txt1=total.substring('0',totalindex);
                        txt1=txt1.replace(' ','');
                        var txt2=total.substring(totalindex+6,total.length);
                       /*  alert(txt1); 
                        alert(txt2); */  
                        txt = txt + txt1;
                        err = err + txt2;
                        if(i+1!=arr.length){
                          txt+='\n';
                          err+='\n';
                        }
                              
             } 
		 
		     /* alert(str); */
			 document.getElementById("show").value=txt;
			 document.getElementById("showerr").value=err;
		});
    function autoTextAreaHeight(o) {
        o.style.height = o.scrollTop + o.scrollHeight + "px";
    }
    $(function () {
        var ele = document.getElementById("symptomTxt");
        autoTextAreaHeight(ele);
    }) --%>
    </script>
    
  </head>
  
  <body>
    <p>Customer service</p>
    <a href="#" onclick="javascript:downloadtest('${app.id}')"  id="pluginurl"  style="color: #83AFE2;text-decoration:underline;">down</a>
    <a href="#" onclick="javascript:downZip('${app.id}')"  id="downzip"  style="color: #83AFE2;text-decoration:underline;">downZip</a>
    <br>
    <br>
    <br>
    <p>operating</p>
    <a href="#" onclick="javascript:downCzZip('${app.id}')"  id="downCzzip"  style="color: #83AFE2;text-decoration:underline;">downZip</a>
    <br>
    <br>
    <br>
    <p>DD</p>
    <a href="#" onclick="javascript:downloadCanadaList('${app.id}')"  id="downloadCanadaList"  style="color: #83AFE2;text-decoration:underline;">down</a>
    <!-- <textarea id="show" v-model="cureInfo.Symptom" oninput="autoTextAreaHeight(this)"></textarea><textarea v-model="cureInfo.Symptom" id="showerr" oninput="autoTextAreaHeight(this)"></textarea> -->
    <!-- <input type=""  value=""/> -->
	<br>
    <%-- <a href="#" onclick="javascript:downDJ('${app.id}')"  id="downDJ"  style="color: #83AFE2;text-decoration:underline;">downExecl</a> --%>

    <br>
    <br>
    <br>
    <p>B2C</p>
    <a href="#" onclick="javascript:downB2C('${app.id}')"  id="downB2C"  style="color: #83AFE2;text-decoration:underline;">downB2CExecl</a>
    <br>
    <br>
    <br>
    <p>PCA</p>
    <a href="#" onclick="javascript:downPCA('${app.id}')"  id="downPCA"  style="color: #83AFE2;text-decoration:underline;">downPCAExecl</a>
    <br>
    <br>
    <p>EuropeanTaxBill</p>
    <a href="#" onclick="javascript:downEuropeanTaxBill('${app.id}')"  id="downEuropeanTaxBill"  style="color: #83AFE2;text-decoration:underline;">downEuropeanTaxBillExecl</a>
    <br>
    <br>
    <p>EMS</p>
    <a href="#" onclick="javascript:downEMS('${app.id}')"  id="downEMS"  style="color: #83AFE2;text-decoration:underline;">downEMS</a>
    <br>
    <br>
    <p>Wish</p>
    <a href="#" onclick="javascript:downWish('${app.id}')"  id="downWish"  style="color: #83AFE2;text-decoration:underline;">downWish</a>
    <br>
    <br>
    <p>MaBang</p>
    <a href="#" onclick="javascript:downMaBang('${app.id}')"  id="downMaBang"  style="color: #83AFE2;text-decoration:underline;">downMaBang</a>
    <br>
    <br>
    <p>downDeletePDFContentZip</p>
    <a href="#" onclick="javascript:downDeletePDFContentZip('${app.id}')"  id="downDeletePDFContentZip"  style="color: #83AFE2;text-decoration:underline;">downDeletePDFContentZip</a>
    <br>
    <br>
    <p>downLiXiaoFei</p>
    <a href="#" onclick="javascript:downLiXiaoFei('${app.id}')"  id="downLiXiaoFei"  style="color: #83AFE2;text-decoration:underline;">downLiXiaoFei</a>
    <br>
    <br>
    <p>downYaoYe</p>
    <a href="#" onclick="javascript:downloadYaoYe('${app.id}')"  id="downloadYaoYe"  style="color: #83AFE2;text-decoration:underline;">downYaoYe</a>
  </body>
</html>
