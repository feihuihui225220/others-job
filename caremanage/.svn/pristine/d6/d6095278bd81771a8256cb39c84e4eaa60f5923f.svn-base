$(document).ready(function() {
		// 添加巡诊计划按钮
		$('.personInfo_right .addxzplan').click(function(){
			$('.rightnone').hide();
			$('.xunzhenDetail').show();
		// li 单击左右添加事件
		$('.xzul1').on("click","li",function(){
			var text=$(this).text();
			$(this).remove();
			$(".xzul2").append(" <li >"+text+"</li>");
		});

		$(".xzul2").on("click","li", function() {
     	var text1=$(this).text();
			$(this).remove();
			$(".xzul1").append(" <li >"+text1+"</li>");
		 });


	});
		//日历 
		var d = new Date();
		var str = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: str,
			defaultView: 'month',
			editable: true,
			events: [
				{
					title: 'All Day Event',
					start: '2016-10-01'
				},
				{
					title: 'Long Event',
					start: '2016-10-09',
					end: '2016-10-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2016-10-20T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-06-16T16:00:00'
				},
				{
					title: 'Meeting',
					start: '2014-06-12T10:30:00',
					end: '2014-06-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2014-06-12T12:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2014-06-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2014-06-28'
				}
			]
		});
		
	});