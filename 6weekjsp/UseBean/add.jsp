<html>
<body>
<%  String  firstno=request.getParameter("firstno");  
       String  sencondno=request.getParameter("sencondno");  
%>
<jsp:useBean id="t1" class="my.AddBean"   />
<jsp:setProperty name="t1" property="firstno"   value="<%=firstno  %>"  />
<jsp:setProperty name="t1" property="sencondno"   value="<%=sencondno  %>"  />
<%   
   int r=t1.add();
out.println("the sum of two no= "+r);
%>
</body>
</html>

"