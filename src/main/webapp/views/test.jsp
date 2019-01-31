<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="common/index-header.jsp" />
<body>

   <a id="btn">
       send
   </a>

   <script>
       $(function(){
           $("#btn").click(function(){
               $.ajax({
                   url:"http://video.qilinxuan.net/cscs",
                   type:"get",
                   headers:{'token':'111'},
                   success:function(result){
                        console.log(result);
                   }
               });
           });
       })
   </script>

</body>
</html>
