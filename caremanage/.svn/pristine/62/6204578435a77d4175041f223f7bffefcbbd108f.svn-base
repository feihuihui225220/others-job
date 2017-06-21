<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <style>
        .center{width:300px;height:300px;position:absolute;top:50%;left:50%;margin:-150px 0  0 -150px;}
        .btn{font-size: 18px;
    display: block;
    background-color: #2095f2;
    border-color: #2095f2;
    width: 90%;
    margin-left: 5%;
    margin-right: 5%;
    color: #fff;
    height: 35px;
    line-height: 35px;
    border-radius: 4px;
    text-align: center;}
    </style>
</head>
<body>
<div class="center">
    <div style="margin-top:20px;margin-left:15px;width:90%;">
        <label style="font-size:18px;">志愿者ID:</label>
        <input type="text" name="" id="exampleInputName1" style="border-radius:4px;height: 25px;line-height: 25px;float:right;width:170px;">
    </div>
    <div style="text-align:center;margin-top:40px;">
        <a class="btn">登录</a>
    </div>
</div>
</body>
<script>

  
    $(".btn").click(function(){
        var id_reg = /^[0-9]*$/;
        var id = $("#exampleInputName1").val();
		if(id==""){
			alert("请输入志愿者ID");
            return false;
		}
        if(!id_reg.test(id)){
            alert("您输入的id必须为数字");
            return false;
        }else{
            $.ajax({
                    url: "/professional/volunteer/findById?id="+id,
                    type: "get",
                    success: function (json) {
                        if(json==-1){
                            alert("您没有参加过活动！");
                        }else if(json==0){
                            alert("该志愿者不存在！");
                        }else{
                            location.href="/professional/volunteer/nVolunteerAssess?volunteerId="+id;
                        }
                    }    
                });


        }
    })
 
    
    
    
    
</script>
</html>