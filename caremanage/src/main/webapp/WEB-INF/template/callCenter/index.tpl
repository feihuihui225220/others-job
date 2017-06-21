<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>CallCenter事务办理</title>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
            <div class="f_l left pad10">
                <div class="usertitle mgb10 strong clearfix">
                    <ul class="inpubox2 clearfix">
                        <li class="inpubox2_li"><p>姓名：</p><span>$!{rUser.name}</span></li>
                        <li class="inpubox2_li"><p>身份证号：</p><span>$!{rUser.idCardNo}</span></li>
                        <li class="inpubox2_li"><p>联系电话：</p><span>$!{rUser.contactPhone}</span></li>
                        <li class="inpubox2_li"><p>家庭住址：</p><span>$!{rUser.hrAddr}</span></li>
                    </ul>
                </div>
                <div class="tablebox">
                    <div class="ggfwzyfw">
                        <div class="ggfw">
                            <button class="tablebox_button"
                                    #if(${rUser.id})onclick="javascript:location.href='/callCenter/pubServer/$!{rUser.id}'"
                                    #else disabled="true" #end>公共服务
                            </button>
                        </div>
                        <div class="zyfw">
                            <button class="tablebox_button"
                                    #if(${rUser.id})onclick="javascript:location.href='/callCenter/proServer/$!{rUser.id}/${rUser.idCardNo}'"
                                    #else disabled="true" #end>专业服务
                            </button>
                        </div>
                    </div>
                    <div class="gafwtsfw">
                        <div class="gafw">
                            <button class="tablebox_button"
                                    #if(${rUser.id})onclick="javascript:location.href='/care/serviceType/serviceList?type=2&userId=$!{rUser.id}'"
                                    #else disabled="true" #end>关爱服务
                            </button>
                        </div>
                        <div class="tsfw">
                            <button class="tablebox_button"
                                    #if(${rUser.id})onclick="javascript:location.href='/care/order/userOrderListByIdcard?idcard=${rUser.idCardNo}'"
                                    #else disabled="true" #end>投诉
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="f_l pad10 table47">
                <div class="usertitle mgb10 strong clearfix">
                    <div class="f_r fr_itbn mgb5">&nbsp;</div>
                    搜索
                </div>
                <ul class="inpubox clearfix">
                    <form method="get" action="/callCenter/searchUser">
                        <li>
                            <input style="width:240px; padding:5px;" placeholder="输入身份证号进行搜索" class="text150"
                                   type="text" name="idcard" value="$!{idcard}">
                        </li>
                        <li><input style="width:80px;" class="ibtn button_btn" type="submit" value="搜索"></li>
                    </form>
                </ul>
                <div class="tablebox">
                    <table class="table100 usertable cen">
                        <tr>
                            <th>姓名</th>
                            <th>身份证号</th>
                        </tr>
                        <tr class="limitid_1">
                            <td>$!{rUser.name}</td>
                            <td>$!{rUser.idCardNo}</td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>