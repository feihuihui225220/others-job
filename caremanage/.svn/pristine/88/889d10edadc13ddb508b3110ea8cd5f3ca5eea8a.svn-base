<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>我的服务</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
<link rel="stylesheet" href="/assets/newCss/common.css" />
<style>
table{border:0px }
.table{margin:0;padding:0 !important;}
.table tr{margin:0;padding:0 !important}
.table tr td{margin:0;padding:0 !important}
.table tr th{ border-left:1px solid #8ed7f8;border-right:1px solid #8ed7f8;height:30px;line-height: 30px;font-size:18px;}
.td1{width:16%;}
.td2{width:14.25%;}
.td3{width:11.15%;}
.td4{width:43%;text-align: left;}
.myPrintArea{padding:0px;}
.img_{margin:0px;}
</style>
</head>
<body>

<div class="wrapper">
        <div class="searchli">
            <ul class="inpubox clearfix">
                <li style="height:38px;line-height:50px" class="b">我的服务</li>
                <li class="rightbtn pad10" style="float:right;"><button class="button_gm addEvidence" onclick="javascripts:location.href='/professional/input?userId=${userId}&serviceId=61'">数据录入</button></li>
                <li class="rightbtn pad10" style="float:right;"><button class="button_gm addEvidence" id="myPrintArea">打印</button></li>
            </ul>
        </div><br>
        <div class="myPrintArea" style="font-size:30px;font-family:楷体;">
        <img class="img_" src="/assets/css/img/zhineng.jpg" style="width:100%;"/>
        <div style="width: 1050px; height: 80px;margin-top: 5px;">
            <table class="table"  frame=above frame=below>
                <tr>
                    <td  style="font-size:30px;font-family:楷体;">姓名</td>
                    <td  style="font-size:30px;font-family:楷体;">性别</td>
                    <td  style="font-size:30px;font-family:楷体;">身高</td>
                    <td  style="font-size:30px;font-family:楷体;">体重</td>
                </tr>
                <tr>
                    <td  style="font-size:30px;font-family:楷体;">$!{user.name}</td>
                    <td  style="font-size:30px;font-family:楷体;">#if($!{user.gender}==0)女#else男#end</td>
                    <td  style="font-size:30px;font-family:楷体;" class="hei">$!str</td>
                    <td  style="font-size:30px;font-family:楷体;" class="wei">$!str</td>
                </tr>
            </table>
        </div>
        <div></div>
        <table class="table" style="font-size:30px;font-family:楷体;">
            <tr>
                <th  style="width:13.2%;" style="font-size:30px;font-family:楷体;">类别</th>
                <th style="width:14.34%;" style="font-size:30px;font-family:楷体;">细项</th>
                <th style="width:11.44%;" style="font-size:30px;font-family:楷体;">测量值</th>
                <th style="width:12.80%;" style="font-size:30px;font-family:楷体;">正常范围</th>
                <th style="width:11%;" style="font-size:30px;font-family:楷体;">异常否</th>
                <th style="width:42%;" style="font-size:30px;font-family:楷体;">建议</th></th>
                
            </tr>
            #foreach($data in $datas)
            <tr style="cursor:pointer" class="select_date" date-userId="${userId}" date-serviceId="${data.serviceId}" date-stype="${data.type}" >
                #if(${data.serviceName}!="体重管理服务")
                <td  style="font-size:30px;font-family:楷体;" >${data.serviceName}</td>
                #set($i = 0)
                 <td  style="font-size:30px;font-family:楷体;" colspan=5 style="padding:0px;">
                 #foreach($title in $data.data.titles)
                    #if(${title}!=""&&${title}!="体型类型"&&${title}!="R波个数"&&${title}!="R波形成功分析的个数"&&${title}!="平均t波 电压"&&${title}!="BMI"&&${title}!="脉搏"&&${title}!="平均压")
                        #if(${data.serviceName}=="心电管理服务（益体康）")
                        <table class="table xindian" style="margin:0px;">
                        #else
                        <table class="table " style="margin:0px;">
                        #end
                            <tr>
                                <td  style="font-size:30px;font-family:楷体;" style="width:9.7%;">${title}</td>
                                <td  style="font-size:30px;font-family:楷体;" class="td1" >
                                #if(${title}=="上传时间")
                                    $!date.format("yyyy-MM-dd",$data.data.values[0][$i])
                                #else
                                    $data.data.values[0][$i]
                                #end    
                                </td>
                                    
                                    #if(${title}=="收缩压(高压)")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2" >90-140</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3" >
                                                #if($data.data.values[0][$i]<=140&&$data.data.values[0][$i]>90)
                                                    正常血压
                                                #elseif($data.data.values[0][$i]<=90)
                                                    低血压
                                                #elseif($data.data.values[0][$i]==120)
                                                    理想血压
                                                #elseif($data.data.values[0][$i]<=159&&$data.data.values[0][$i]>140)
                                                    Ⅰ级高血压（轻度）
                                                #elseif($data.data.values[0][$i]<=179&&$data.data.values[0][$i]>=160)
                                                    Ⅱ级高血压（中度）
                                                #elseif($data.data.values[0][$i]>=180)
                                                    Ⅲ级高血压（重度）
                                                #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4" >
                                                #if($data.data.values[0][$i]>90&&$data.data.values[0][$i]<140)
                                                    维持现状,注意定期检测血压.
                                                #elseif($data.data.values[0][$i]<=90)
                                                    1.注意多补充水分,脱水或缺水血压容易低;
                                                    2.尽量不要吃太饱,要少食多餐;
                                                    3.起床时,先坐一会,再把脚垂到地上,再起身;
                                                    4.运动之后不仅需要补充水分,还要补点盐;
                                                    5.定期检测血压.
                                                <!-- 收缩压和舒张压且  的关系  -->#set($a=$i+1)
                                                #elseif($data.data.values[0][$i]>=140&&$data.data.values[0][$a]< 90)
                                                    1.运动时要采取循序渐渐的方式增加活动量;
                                                    1.尽量戒烟戒酒;
                                                    2.保持心理平衡,避免情绪激动;
                                                    4.定期检测血压.
                                                <!-- 跳出循环 -->
                                                #elseif($data.data.values[0][$i]>=140&&$data.data.values[0][$i]< 159)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #elseif($data.data.values[0][$i]>=160&&$data.data.values[0][$i]< 170)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #elseif($data.data.values[0][$i]>=180)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #end
                                        </td>
                                    #elseif(${title}=="舒张压(低压)")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">60-90</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                                #if($data.data.values[0][$i]<=90&&$data.data.values[0][$i]>60)
                                                    正常血压
                                                #elseif($data.data.values[0][$i]<=90)
                                                    低血压
                                                #elseif($data.data.values[0][$i]==80)
                                                    理想血压
                                                #elseif($data.data.values[0][$i]<=99&&$data.data.values[0][$i]>90)
                                                    Ⅰ级高血压（轻度）
                                                #elseif($data.data.values[0][$i]<=109&&$data.data.values[0][$i]>=100)
                                                    Ⅱ级高血压（中度）
                                                #elseif($data.data.values[0][$i]>=110)
                                                    Ⅲ级高血压（重度）
                                                #end
                                        </td>
                                        
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                                #if($data.data.values[0][$i]>60&&$data.data.values[0][$i]<=90)
                                                    维持现状,注意定期检测血压.
                                                #elseif($data.data.values[0][$i]<=60 )
                                                    1.注意多补充水分,脱水或缺水血压容易低;
                                                    2.尽量不要吃太饱,要少食多餐;
                                                    3.起床时,先坐一会,再把脚垂到地上,再起身;
                                                    4.运动之后不仅需要补充水分,还要补点盐;
                                                    5.定期检测血压.
                                                <!-- 收缩压和舒张压且  的关系  -->#set($a=$i-1)
                                                #elseif($data.data.values[0][$a]>=99&&$data.data.values[0][$i]< 90)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #elseif($data.data.values[0][$a]>=109&&$data.data.values[0][$i]< 100)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #elseif($data.data.values[0][$i]>=110)
                                                    1.饮食控制;
                                                    2.改善动物性食物结构,少食含脂肪高的猪肉,多食含蛋白质较高而脂肪较少的禽类和鱼类;
                                                    3.减少盐的摄人,建议每人每日不超过6g;
                                                    4.应增加含钾.钙高的食物,如绿叶菜.鲜奶.豆类制品等;
                                                    5.降低体重和戒烟戒酒;
                                                    6.增加有氧运动;如体适能锻炼
                                                    7.心情愉快,减轻精神压力;如心理团辅.音乐辅疗等
                                                    8.随时监控血压,血压升高或过低,血压波动大,出现眼花,头晕,恶心呕吐,视物不清,偏瘫,失语,意识障碍,呼吸困难,肢体乏力等即到医院就医
                                                #end
                                        </td>
                                        #elseif(${title}=="脉压差")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">30--60mmHg</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                                #if($data.data.values[0][$i]<=60&&$data.data.values[0][$i]>30)
                                                    正常压差：未见明显异常
                                                #elseif($data.data.values[0][$i]<=30)
                                                    脉压差过小
                                                #elseif($data.data.values[0][$i]>60)
                                                    脉压差过大
                                                #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                                #if($data.data.values[0][$i]>30&&$data.data.values[0][$i]<=60)
                                                    正常压差：未见明显异常
                                                #elseif($data.data.values[0][$i]>60 )
                                                    常见于动脉瓣关闭不全.主动脉硬化.甲亢.严重贫血.风湿性心脏病.部分先天性心脏病与高血压心脏病等.
                                                    建议到医院进行全面检查,对因治疗,并保持健康的生活方式对防治高血压也很重要,饮食上应低盐.低脂,避免精神刺激,
                                                    控制体重,并要适当运动如体适能锻炼.同时应检查有无血糖.血脂增高的情况,并积极防治.
                                                <!-- 收缩压和舒张压且  的关系  -->#set($a=$i-1)
                                                #elseif($data.data.values[0][$i]<30)
                                                    脉压差过小多见于高血压早期者.由于交感神经兴奋性增高,全身体表小血管痉挛,以致收缩压不高,舒张压相对增高,脉压差变小.
                                                    建议增强自我保健意识,防患于未然：定期复查血压,发现问题及时纠正,做到生活规律.起居正常.注意饮食.积极锻炼.坚持服药.
                                                #end
                                        </td>
                                    #elseif(${title}=="脂肪含量")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">#if(${user.gender}==1)10-20% #else 20-30% #end</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if(${user.gender}==1&&$data.data.values[0][$i]<=20&&$data.data.values[0][$i]>=10)
                                                标准
                                            #elseif(${user.gender}==1&&$data.data.values[0][$i]<10)
                                                偏瘦
                                            #elseif(${user.gender}==1&&$data.data.values[0][$i]<=25&&$data.data.values[0][$i]>20)
                                                轻度
                                            #elseif(${user.gender}==1&&$data.data.values[0][$i]>25)
                                                肥胖
                                            #elseif(${user.gender}==0&&$data.data.values[0][$i]<=30&&$data.data.values[0][$i]>=20)
                                                标准
                                            #elseif(${user.gender}==0&&$data.data.values[0][$i]<20)
                                                偏瘦
                                            #elseif(${user.gender}==0&&$data.data.values[0][$i]<=35&&$data.data.values[0][$i]>30)
                                                轻度
                                            #elseif(${user.gender}==0&&$data.data.values[0][$i]>35)
                                                肥胖
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if(${user.gender}==1&&$data.data.values[0][$i]<10||${user.gender}==2&&$data.data.values[0][$i]<20)
                                                1.脂肪率偏低,注意保持一定的运动量;
                                                2.同时注意增加营养,多吃富含动物性蛋白质的肉.蛋和奶,还要适当多吃豆类和豆制品及蔬菜和瓜果.
                                            #elseif(${user.gender}==1&&$data.data.values[0][$i]<=20&&$data.data.values[0][$i]>=10||${user.gender}==0&&$data.data.values[0][$i]<=30&&$data.data.values[0][$i]>=20)
                                                正常,维持现状,同时经常参加体育锻炼和注意合理的膳食.
                                            #elseif(${user.gender}==1&&$data.data.values[0][$i]>20||${user.gender}==0&&$data.data.values[0][$i]>30)
                                                1.脂肪率偏高时,必须检测血脂肪.血糖.肝功能.心血管功能等,是否潜藏危害健康因子;
                                                2.同时找出肥胖原因后,再设计出适合自己并可持续的饮食控制.运动及改变生活方式,有效降低.控制脂肪率.
                                            #end
                                        </td>
                                    #elseif(${title}=="体质指数")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">18.5-24.9</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]<=24.9&&$data.data.values[0][$i]>=18.5)
                                                标准
                                            #elseif($data.data.values[0][$i]<18.5)
                                                偏瘦
                                            #elseif($data.data.values[0][$i]<=24&&$data.data.values[0][$i]>=27.9)
                                                超重
                                            #elseif($data.data.values[0][$i]>=28)
                                                肥胖
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]<18.5)
                                                1.科学的运动：以重量训练为主,最好少参加耐力性运动（如长跑）;
                                                2.合理的膳食：多样但不可偏食,除了食用富含动物性蛋白质的肉.蛋和奶,还要适当多吃豆类和豆制品及蔬菜和瓜果
                                            #elseif($data.data.values[0][$i]<=23.9&&$data.data.values[0][$i]>=18.5)
                                                维持现状,同时也要保持适当的运动量和膳食的摄入.
                                            #elseif($data.data.values[0][$i]<=27.9&&$data.data.values[0][$i]>=24.0)
                                                1.经常进行有氧健身训练;
                                                2.膳食方面控制肉食和脂肪含量高的食品,多吃蔬菜（如黄瓜.白萝卜.韭菜.冬瓜.辣椒.大豆及豆制品等）.
                                            #elseif($data.data.values[0][$i]>=28.0)
                                                1.坚持快走.慢跑或者健身操,每周运动至少为3-4次,时间控制在30-40分钟;
                                                2.膳食方面减少脂肪及糖类的摄入,多吃富含水分.纤维素及能够促进排便.排尿的食物.
                                            #end
                                        </td>
                                    #elseif(${title}=="血氧饱和对")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">≥95</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=95)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=95)
                                                正常范围中,无异常.
                                            #else
                                                此项指标偏低,有缺氧现象,但缺氧原因很多,主要见于心肺疾病.建议去医院检查心肺,缺氧可通过吸氧来改善,明确缺氧原因,再对因治疗.
                                            #end
                                        </td>
                                    #elseif(${title}=="体重")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">暂无标准</td>
                                    #elseif(${title}=="ST段是否正常")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]=="ST段正常")
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]=="ST段正常")
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到"三低"即:低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                        #elseif(${title}=="心率是否失常")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]=="没有发现心律失常")
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]=="没有发现心律失常")
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="波形质量是否正常")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]=="波形质量正常")
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]=="波形质量正常")
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                        
                                            #elseif(${title}=="心率是否正常")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]=="心率过慢")
                                                不正常
                                            #else
                                                正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]=="心率过慢")
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #else
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #end
                                        </td>
                                    #elseif(${title}=="整体波形是否正常")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]=="整体波形异常")
                                                不正常
                                            #else
                                                正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]=="整体波形异常")
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #else
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #end
                                        </td>
                                    #elseif(${title}=="心率信息")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">60≤值≤100</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=60&&$data.data.values[0][$i]<=100)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=60&&$data.data.values[0][$i]<=100)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="全局的pR间期")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">120≤值≤200</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=120&&$data.data.values[0][$i]<=200)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=120&&$data.data.values[0][$i]<=200)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="平均QT间期")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">340≤值≤430</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=340&&$data.data.values[0][$i]<=430)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=340&&$data.data.values[0][$i]<=430)
                                            定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="平均R波电压")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">0.5≤值≤2.0</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=0.5&&$data.data.values[0][$i]<=2.0)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=0.5&&$data.data.values[0][$i]<=2.0)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="平均p波电压")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">≤0.25</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]<=0.25)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]<=0.25)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    
                                        
                                    #elseif(${title}=="ST段平均电压")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">-0.05≤值≤0.3</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=-0.05&&$data.data.values[0][$i]<=-0.05)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=-0.05&&$data.data.values[0][$i]<=-0.05)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="全局rr间期")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">1000≤值≤600</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]>=600&&$data.data.values[0][$i]<=1000)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]>=600&&$data.data.values[0][$i]<=1000)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                    #elseif(${title}=="全局qtc间期")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">＜440ms</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if($data.data.values[0][$i]<440)
                                                正常
                                            #else
                                                不正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if($data.data.values[0][$i]<440)
                                                定期检测心电图,以利于心脏病变的及早发现和早期治疗.
                                            #else
                                                1.到医院做全面检查,并定期接受心电图监测,如有异常及时去医院就诊;按医嘱服用药物,按时服药,预防为主.
                                                2.规律生活 养成健康的生活习惯.生活有规律,心情愉快,避免情绪激动和过度劳累.老年人外出需要有人陪伴,不要独居.
                                                3.饮食方面原则上应做到“三低”即：低热量.低脂肪.低胆固醇.少吃甜食,多吃高蛋白.高维生素食物玉米,多吃果蔬如西瓜.西红柿.苹果.海带.洋葱.木耳以及杏仁.花生等坚果,少吃刺激性食物
                                                4.合理运动,强壮心脏,如散步.慢跑.太极拳或体适能锻炼等有氧运动.
                                                5.控制体重和戒烟戒酒多饮水.茶水代替咖啡.
                                            #end
                                        </td>
                                        #elseif(${title}=="基础代谢值")
                                        <td  style="font-size:30px;font-family:楷体;" class="td2"> 
                                            #if(${user.age}>=50&&${user.age}<=69)
                                            男:1350<br>女:1110<br>
                                            #elseif(${user.age}>=70)
                                            男:1220<br>女:1010<br>
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">
                                            #if(${user.gender}==1&&${user.age}>=30&&${user.age}<=49&&$data.data.values[0][$i]<=1500)
                                                不正常
                                            #elseif(${user.gender}==1&&${user.age}>=50&&${user.age}<=69&&$data.data.values[0][$i]<=1350)
                                                不正常
                                            #elseif(${user.gender}==1&&${user.age}<=70&&$data.data.values[0][$i]<=1220)
                                                不正常
                                            #elseif(${user.gender}==0&&${user.age}>=30&&${user.age}<=49&&$data.data.values[0][$i]<=1170)
                                                不正常
                                            #elseif(${user.gender}==0&&${user.age}>=50&&${user.age}<=69&&$data.data.values[0][$i]<=1110)
                                                不正常
                                            #elseif(${user.gender}==0&&$${user.age}<=70&&$data.data.values[0][$i]<=1010)
                                                不正常
                                            #else
                                                正常
                                            #end
                                        </td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">
                                            #if(${user.gender}==1&&${user.age}>=30&&${user.age}<=49&&$data.data.values[0][$i]<=1500)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #elseif(${user.gender}==1&&${user.age}>=50&&${user.age}<=69&&$data.data.values[0][$i]<=1350)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #elseif(${user.gender}==1&&${user.age}<=70&&$data.data.values[0][$i]<=1220)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #elseif(${user.gender}==0&&${user.age}>=30&&${user.age}<=49&&$data.data.values[0][$i]<=1170)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #elseif(${user.gender}==0&&${user.age}>=50&&${user.age}<=69&&$data.data.values[0][$i]<=1110)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #elseif(${user.gender}==0&&$${user.age}<=70&&$data.data.values[0][$i]<=1010)
                                                1.增加运动量,有氧运动是提高代谢最快速的方法;
                                                2.增强肌肉训练;
                                                3.保障蛋白质的摄入,多喝白开水,同时补充B族维生素;
                                                4.注意生活细节,如热水泡脚,按摩四肢等.
                                            #else
                                                正常,如果基础代谢快导致又不舒服的感觉,建议去医院就诊,看是否存在甲亢.
                                            #end
                                        </td>
                                    #else
                                        <td  style="font-size:30px;font-family:楷体;" class="td2">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td3">暂无标准</td>
                                        <td  style="font-size:30px;font-family:楷体;" class="td4">暂无标准</td>
                                    #end
                            </tr>
                        </table>
                #end
                #set($i = $i + 1)
                #end
                </td>
            </tr>
            #elseif(${data.serviceName}=="体重管理服务")
            #set($i = $i + 1)
            #if($data.data.titles.size()!=0)
                    <input type="hidden" id="weight" value="$data.data.values[0][2]"/>
            #end
            #end
            #if(${data.serviceName}=="脂肪管理服务")
            #if($data.data.titles.size()!=0)
               <input  type="hidden" id="tizhi" value="$data.data.values[0][2]"/>
            #end
            #end
            
            #end
        </table>
        </div>
      <!--  <ul class="list_my zhanshi">
            #foreach($data in $datas)
            <li class="b">
              <h4><a href="/professional/service/diverseShow?userId=${userId}&serviceId=${data.serviceId}&stype=${data.type} ">${data.serviceName}</a></h4>
                #set($i = 0)
                #foreach($title in $data.data.titles)
                    <div>
                        <h5>${title}</h5>
                        #if($title.equals("上传时间"))
                            <b>$!date.format('yyyy-MM-dd',$!data.data.values[0][$i])</b>
                        #else
                            <b>$data.data.values[0][$i]</b>
                        #end
                    </div>
                    #set($i = $i + 1)
                #end                
                </a>
             
           </li>
           #end
        </ul>-->
   
    <div class="footer"></div>
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/jQuery.print.js"></script>
<script>
    $(function(){
        var tizhi=$("#tizhi").val();
        
        var wei=$("#weight").val();
        
        $(".hei").html(Math.sqrt(wei/tizhi).toFixed(2)*100);
        $(".wei").html(wei);
        //$('#img').html($img);
        $('.b').each(function(){
            if($(this).find('div').length==0){
                $(this).remove();
            }else{
                $(this).addClass("height");         
            }
            
        });
        
        $('.select_date').click(function(){
            var userId=$(this).attr('date-userId');
            var serviceId=$(this).attr('date-serviceId');
            var stype=$(this).attr('date-stype');
            location.href="/professional/service/diverseShow?userId="+userId+"&serviceId="+serviceId+"&stype="+stype;
        });
           
        $('.a_serviceId').each(function(){
            if($(this).find('div').length!=0){
                $(this).remove();
            }
            var serviceName=$(this).attr("date-serviceName");
            var IdCardNo=$IdCardNo;
            if($(this).attr("date-value")==30){
                 
                 $.ajax({
                 url :"http://114.251.187.74:8115/stration/eeg/userList?IdCodNo="+IdCardNo,
                 dataType : "jsonp",
                 jsonp: "jsonpCallback",
                 success:function(json){
                    if(json.datatable.length!=0){
                        var stype=$(this).attr("date-stype");
                        
                        var userId=$userId;
                         for(var i=0;i<json.datatable.length;i++){
                                var n=i+1;
                                //var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td  style="font-size:30px;font-family:楷体;">'+n+'</td><td  style="font-size:30px;font-family:楷体;"></td></tr>');
                                var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td  style="font-size:30px;font-family:楷体;">'+n+'</td><td  style="font-size:30px;font-family:楷体;"></td></tr>');
                                $('.tabImg').append(tab);
                                var div=$('<li class="b"><h4><a href="/professional/service/history?userId='+userId+'&serviceId=30" >'+serviceName+'</a></h4><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic1Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic2Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic3Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic4Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic5Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic6Url+'"/></li>');
                                //var div=$('<li class="b"><h4><a href="/professional/service/history?userId='+userId+'&serviceId=30" >'+serviceName+'</a></h4><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td  style="font-size:30px;font-family:楷体;"><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td  style="font-size:30px;font-family:楷体;"><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td  style="font-size:30px;font-family:楷体;"><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td  style="font-size:30px;font-family:楷体;"><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td  style="font-size:30px;font-family:楷体;"><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></li>');
                                $('.zhanshi').append(div);  
                                break;  
                        }
                        remove();
                    }
                   
                 } 
             });
            }
            
        });
        $('#myPrintArea').click(function(){
            $.print(".myPrintArea");
        });
    });
    function remove(){
        $('.a_serviceId').each(function(){
            if($(this).attr("date-value")==30){
                $(this).html("");
            }
        });
    }
    
    window.onload=function(){
        $(".xindian tr td:nth-child(4)").each(function(){
               var result=$(this).text().replace(/(^\s+)|(\s+$)/g,"");//去掉前后空格
           if(result=="不正常"){
             remove();
             return false;
           }
        });
    };
    function remove(){
       var i=1;
      $(".xindian tr td:nth-child(5)").each(function(){ 
           $(this).remove();
      });
      $(".xindian").each(function(){
       if(i==1){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体; border:0px;" class="td4">1.到医院做全面检查,并定期<br>接受心电图监测,如有异常及</td>');
       }else if(i==2){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4"> 时去医院就诊;按医嘱服用药<br>物,按时服药,预防为主.</td>');
       }else if(i==3){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">2.规律生活养成健康的生活<br>习惯.生活有规律,心情愉快,</td>');
       }else if(i==4){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">避免情绪激动和过度劳累.老<br>年人外出需要有人陪伴,不要</td>');
       }else if(i==5){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">独居.3.饮食方面原则上应做<br>到"三低"即:低热量.低脂肪.</td>');
       }else if(i==6){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">低胆固醇.少吃甜食,多吃高<br>蛋白.高维生素食物玉米,多</td>');
       }else if(i==7){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">吃果蔬如西瓜.西红柿.苹果.<br>海带.洋葱.木耳以及杏仁.花</td>');
       }else if(i==8){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">生等坚果,少吃刺激性食物4.<br>合理运动,强壮心脏,如散步.</td>');
       }else if(i==9){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">慢跑.太极拳或体适能锻炼等<br>有氧运动.5.控制体重和戒烟</td>');
       }else if(i==10){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4">戒酒多饮水.茶水代替咖啡.</td>');
       }else if(i==11){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4"></td>');
       }else if(i==12){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4"></td>');
       }else if(i==13){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4"></td>');
       }else if(i==14){
          $(this).find("tr:nth-child(1)").append('<td style="font-size:30px;font-family:楷体;border:0px;" class="td4"></td>');
       }
      i++;
      
      });
     
    }
</script>
</body>
</html>