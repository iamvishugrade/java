<html>
<body>
<jsp:useBean id="t1" class="my.AddBean"   />
<jsp:setProperty name="t1" property="*"     />
<%   
   int r=t1.add();
out.println("the sum of two no via add2= "+r);
%>
</body>
</html>

