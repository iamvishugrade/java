<html>
<body>
<jsp:useBean id="t1" class="my.AddBean"   />
<jsp:setProperty name="t1" property="firstno"   param="firstno"  />
<jsp:setProperty name="t1" property="sencondno"   param="sencondno"  />
<%   
   int r=t1.add();
out.println("the sum of two no= "+r);
%>
</body>
</html>

