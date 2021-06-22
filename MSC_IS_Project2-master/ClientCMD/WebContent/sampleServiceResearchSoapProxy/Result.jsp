<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServiceResearchSoapProxyid" scope="session" class="serv.ServiceResearchSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServiceResearchSoapProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServiceResearchSoapProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServiceResearchSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        serv.ServiceResearchSoap getServiceResearchSoap10mtemp = sampleServiceResearchSoapProxyid.getServiceResearchSoap();
if(getServiceResearchSoap10mtemp == null){
%>
<%=getServiceResearchSoap10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String skill_1id=  request.getParameter("skill18");
            java.lang.String skill_1idTemp = null;
        if(!skill_1id.equals("")){
         skill_1idTemp  = skill_1id;
        }
        byte[] getResearchrsBySkill15mtemp = sampleServiceResearchSoapProxyid.getResearchrsBySkill(skill_1idTemp);
if(getResearchrsBySkill15mtemp == null){
%>
<%=getResearchrsBySkill15mtemp %>
<%
}else{
        String tempreturnp16 = "[";        for(int ireturnp16=0;ireturnp16< getResearchrsBySkill15mtemp.length;ireturnp16++){
            tempreturnp16 = tempreturnp16 + getResearchrsBySkill15mtemp[ireturnp16] + ",";
        }
        int lengthreturnp16 = tempreturnp16.length();
        tempreturnp16 = tempreturnp16.substring(0,(lengthreturnp16 - 1)) + "]";
        %>
        <%=tempreturnp16%>
        <%
}
break;
case 20:
        gotMethod = true;
        String firstName_2id=  request.getParameter("firstName23");
            java.lang.String firstName_2idTemp = null;
        if(!firstName_2id.equals("")){
         firstName_2idTemp  = firstName_2id;
        }
        String lastName_3id=  request.getParameter("lastName25");
            java.lang.String lastName_3idTemp = null;
        if(!lastName_3id.equals("")){
         lastName_3idTemp  = lastName_3id;
        }
        byte[] getResearcherByName20mtemp = sampleServiceResearchSoapProxyid.getResearcherByName(firstName_2idTemp,lastName_3idTemp);
if(getResearcherByName20mtemp == null){
%>
<%=getResearcherByName20mtemp %>
<%
}else{
        String tempreturnp21 = "[";        for(int ireturnp21=0;ireturnp21< getResearcherByName20mtemp.length;ireturnp21++){
            tempreturnp21 = tempreturnp21 + getResearcherByName20mtemp[ireturnp21] + ",";
        }
        int lengthreturnp21 = tempreturnp21.length();
        tempreturnp21 = tempreturnp21.substring(0,(lengthreturnp21 - 1)) + "]";
        %>
        <%=tempreturnp21%>
        <%
}
break;
case 27:
        gotMethod = true;
        byte[] getAllResearchrsInformation27mtemp = sampleServiceResearchSoapProxyid.getAllResearchrsInformation();
if(getAllResearchrsInformation27mtemp == null){
%>
<%=getAllResearchrsInformation27mtemp %>
<%
}else{
        String tempreturnp28 = "[";        for(int ireturnp28=0;ireturnp28< getAllResearchrsInformation27mtemp.length;ireturnp28++){
            tempreturnp28 = tempreturnp28 + getAllResearchrsInformation27mtemp[ireturnp28] + ",";
        }
        int lengthreturnp28 = tempreturnp28.length();
        tempreturnp28 = tempreturnp28.substring(0,(lengthreturnp28 - 1)) + "]";
        %>
        <%=tempreturnp28%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>