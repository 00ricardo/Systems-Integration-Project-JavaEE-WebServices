<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="samplePublicationsSoapProxyid" scope="session" class="serv.PublicationsSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
samplePublicationsSoapProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = samplePublicationsSoapProxyid.getEndpoint();
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
        samplePublicationsSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        serv.PublicationsSoap getPublicationsSoap10mtemp = samplePublicationsSoapProxyid.getPublicationsSoap();
if(getPublicationsSoap10mtemp == null){
%>
<%=getPublicationsSoap10mtemp %>
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
        String title_1id=  request.getParameter("title18");
            java.lang.String title_1idTemp = null;
        if(!title_1id.equals("")){
         title_1idTemp  = title_1id;
        }
        byte[] getPublicationByTitle15mtemp = samplePublicationsSoapProxyid.getPublicationByTitle(title_1idTemp);
if(getPublicationByTitle15mtemp == null){
%>
<%=getPublicationByTitle15mtemp %>
<%
}else{
        String tempreturnp16 = "[";        for(int ireturnp16=0;ireturnp16< getPublicationByTitle15mtemp.length;ireturnp16++){
            tempreturnp16 = tempreturnp16 + getPublicationByTitle15mtemp[ireturnp16] + ",";
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
        byte[] getPublicationByResearcher20mtemp = samplePublicationsSoapProxyid.getPublicationByResearcher(firstName_2idTemp,lastName_3idTemp);
if(getPublicationByResearcher20mtemp == null){
%>
<%=getPublicationByResearcher20mtemp %>
<%
}else{
        String tempreturnp21 = "[";        for(int ireturnp21=0;ireturnp21< getPublicationByResearcher20mtemp.length;ireturnp21++){
            tempreturnp21 = tempreturnp21 + getPublicationByResearcher20mtemp[ireturnp21] + ",";
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
        byte[] getAllPublications27mtemp = samplePublicationsSoapProxyid.getAllPublications();
if(getAllPublications27mtemp == null){
%>
<%=getAllPublications27mtemp %>
<%
}else{
        String tempreturnp28 = "[";        for(int ireturnp28=0;ireturnp28< getAllPublications27mtemp.length;ireturnp28++){
            tempreturnp28 = tempreturnp28 + getAllPublications27mtemp[ireturnp28] + ",";
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