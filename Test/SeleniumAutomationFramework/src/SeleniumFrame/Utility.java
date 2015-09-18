import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Utility {
	
	private static PrintWriter writer;
	private static BufferedWriter output;
	
	public static void CreateResultFile(String FileName) throws IOException {
	    writer = new PrintWriter(FileName + ".html", "UTF-8");
	    writer.println("<script type='text/javascript'>");
		writer.println("	function toggle_visibility(tbid,lnkid){");
		writer.println("	 if(document.all)");
		writer.println("		{document.getElementById(tbid).style.display = document.getElementById(tbid).style.display == 'block' ? 'none' : 'block';}");
		writer.println("	 else");
		writer.println("		{document.getElementById(tbid).style.display = document.getElementById(tbid).style.display == 'table' ? 'none' : 'table';}");
		writer.println("	  	document.getElementById(lnkid).value = document.getElementById(lnkid).value == '[-] Collapse' ? '[+] Expand' : '[-] Collapse'; }");
		writer.println("</script>");
		writer.println("<style type='text/css'>");
		writer.println(".heading {font-family: Franklin Gothic Medium ; font-style: bold; color: White; font-size: 17pt; background-color: #2B547E;} ");
		writer.println(".Title { font-family: Franklin Gothic Medium ; color:purple;  font-size: 8pt;}");
		writer.println(".subheading {BORDER: #8eb3d8 2px solid;FONT-SIZE: 11pt;COLOR: white;FONT-FAMILY: Franklin Gothic Medium;text-align: center;BACKGROUND-COLOR :  #319AFD;}");
		writer.println(".subheading1{BORDER: #8eb3d8 1px solid;FONT-SIZE: 10pt;COLOR: #3366FF;FONT-FAMILY:Franklin Gothic Medium;text-align: center;HEIGHT: 20px;}") ;
		writer.println(".subheading2{FONT-SIZE: 12pt;FONT-WEIGHT: bold;COLOR:#3B3131;FONT-FAMILY: Franklin Gothic Medium;BACKGROUND-COLOR:White;}");
		writer.println(".border{BORDER: #8eb3d8 1px solid;FONT-SIZE: 10pt;COLOR:#34282C;FONT-WEIGHT: bold;FONT-FAMILY:Calibri;}");
		writer.println(".alt {background-color:#E1EEF4}");
		writer.println(".border_Pass{BORDER: #8eb3d8 1px solid;FONT-SIZE: 9pt;COLOR:Green;BACKGROUND-COLOR:White;FONT-FAMILY:Franklin Gothic Medium;}");
		writer.println(".border_Fail{BORDER: #8eb3d8 1px solid;COLOR: Red;FONT-SIZE: 9pt;BACKGROUND-COLOR:white;FONT-FAMILY:Franklin Gothic Medium;}");
		writer.println(".border_Done{BORDER: #8eb3d8 1px solid;FONT-SIZE: 9pt;COLOR: #0000FF;FONT-FAMILY: Franklin Gothic Medium;}");
		writer.println(".border_Warning{BORDER: #8eb3d8 1px solid;FONT-SIZE:9pt;COLOR: Maroon;FONT-FAMILY: Franklin Gothic Medium;}");
		writer.println(".border_Fail_Final{BORDER: #8eb3d8 1px solid;COLOR:  #0000FF; font-style: bold;FONT-SIZE: 9pt;BACKGROUND-COLOR: #F9966B;FONT-FAMILY: Franklin Gothic Medium;}");	 
		writer.println(".border_Pass_Final{BORDER: #8eb3d8 1px solid;COLOR:  #0000FF; font-style: bold;FONT-SIZE: 9pt;BACKGROUND-COLOR: #B5EAAA;FONT-FAMILY:Franklin Gothic Medium;}");
		writer.println("strong{COLOR:#3366FF;FONT-FAMILY: Franklin Gothic Medium}");
		writer.println("#tbl1,#tbl2,#tbl3,#tbl4,#tbl5,#tbl6,#tbl7,#tbl8,#tbl9,#tbl10,#tbl11,#tbl12,#tbl13,#tbl14,#tbl15  {display:none;}");
		writer.println("#lnk1,#lnk2,#lnk3,#lnk4,#lnk5,#lnk6,#lnk7,#lnk8,#lnk9,#lnk10,#lnk11,#lnk12,#lnk13,#lnk14,#lnk15 {border:none;background:none;width:85px;}");
		writer.println("</style>");
		writer.println("<head>");
		writer.println("	<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' />");
		writer.println("		<title>Detail Report</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("");
		writer.println("<table>");
		writer.println("<tr><td width =100% class= Title align =left > Detail Report<br> </td></td></tr>");
		writer.println("<br></table>");
		writer.println("<table width = 100% border=2 BORDERCOLOR= #0066CC cellpadding=0 > ");
		writer.println("<tr>");
		writer.println("<td class= heading align= center > " + "strDetailedReportHeader" + " : " + "strTestCaseName" + "</td> ");
		writer.println("</tr>");
		writer.println("</table><br>");
		writer.println("<table align='center' width = 100%>");
		writer.println("<tr>");
		writer.println("	<td class='subheading1'>Execution Start Time : " + "Time" + " </td>");
		writer.println("	<td class='subheading1'>Executed By : " + "strUserName" + " </td>");
		writer.println("	<td class='subheading1'>Execution Date  : " + "Date" + "</td>");
		writer.println("</tr>");
		writer.println("</table><br>");
		writer.println("");
		////////////////////////////////////////////////////////////////////////////////////////////
		writer.println("<table width:100% bgcolor='#EEEEEE' cellspacing =0 >");
		writer.println ("	<tr><td bgcolor='#8eb3d8' colspan='3'></td></tr>");
		writer.println ("	<tr>");
		writer.println ("<td width= '70%' bgcolor='#FFDFDD' align ='left'> <strong> Test Case : "+ "testCaseName" +  "&nbsp [ Iteration : #" + "iterationNo" + " ]</strong> </td>");
		writer.println ("	<td width= '30%' bgcolor='#FFDFDD' align ='center'> </td>");
		writer.println ("	<td  width= '20%' bgcolor='#C2DFFF' align='right' ><input id='lnk" + "iHTMLTableLink" + "' type='button' value='[+] Expand' onclick=" + "iHTMLTableLink"  + "','lnk" + "iHTMLTableLink" +"')></td>");
		writer.println ("	</tr>");
		writer.println ("	<tr><td bgcolor='#8eb3d8' colspan='3'></td></tr>	");
		writer.println ("	</table>");
		writer.println ("<table style='word-wrap:break-word;table-layout: fixed'; width=100% id='tbl"+ "iHTMLTableLink" +"' cellspacing=0>" )	;
		writer.println ("	<tr>");
		writer.println ("<td class='subheading'>Step Number</td>");
		writer.println ("<td class='subheading'>Step Name</td>");
        writer.println ("<td class='subheading'>Execution Status</td>");
		writer.println ("<td class='subheading'>Input Value</td>");
		writer.println ("<td class='subheading'>Output Value</td>");
		writer.println ("<td class='subheading'>Error / Message </td>")	;				
		writer.println ("<td class='subheading'>Execution Time</td>");
		writer.close();
	}
	
	public static void UpdateResultFile(String FileName) throws IOException {
		output = new BufferedWriter(new FileWriter(FileName,true));  //clears file every time
		output.append("<tr>");
		output.append("<td class= 'border'>" + "stepNumber" + "</td>");
		output.append("<td class= 'border'>" + "stepName" + "</td>");
		output.append("<td class='border_Pass'>" + "status" + "</td>");
		output.append("</tr>");
		output.close();
	   
	}
	
	public static void WriteCapturedValue(String CapturedData) throws IOException{
	
		//ExcelUtil.setexcelfile("C:\\OFSAA Automation Scripts1\\Input\\InputExcel.xlsx");
		XSSFSheet OutputSheet =ExcelUtil.setexcelsheet("Output");
		ExcelUtil.SetdataInExcel(OutputSheet, 0, 0, CapturedData);
	}

}
