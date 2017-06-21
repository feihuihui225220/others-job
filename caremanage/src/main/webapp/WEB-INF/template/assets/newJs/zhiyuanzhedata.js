// Call this from the developer console and you can control both instances
var calendars = {};

$(document).ready( function() {
    console.info(
        'Welcome to the CLNDR demo. Click around on the calendars and' +
        'the console will log different events that fire.');

    // Assuming you've got the appropriate language files,
    // clndr will respect whatever moment's language is set to.
    // moment.locale('ru');

    // Here's some magic to make sure the dates are happening this month.
    var thisMonth = moment().format('YYYY-MM');
    // Events to load into calendar
     var eventArray = [
        // {
            // title: 'Multi-Day Event',
            // endDate: thisMonth + '-14',
            // startDate: thisMonth + '-10'
        // }, {
            // endDate: thisMonth + '-23',
            // startDate: thisMonth + '-21',
            // title: 'Another Multi-Day Event'
        // }, {
            // date: thisMonth + '-27',
            // title: 'Single Day Event'
        // }
     ];

    // The order of the click handlers is predictable. Direct click action
    // callbacks come first: click, nextMonth, previousMonth, nextYear,
    // previousYear, nextInterval, previousInterval, or today. Then
    // onMonthChange (if the month changed), inIntervalChange if the interval
    // has changed, and finally onYearChange (if the year changed).
    calendars.clndr1 = $('.cal1').clndr({
        events: eventArray,
        clickEvents: {
            click: function (target) {
                $(".day").attr("style","");
                $(".day").attr("id","");
                $(target.element).css("backgroundColor","#96d478");
                $(target.element).attr("id","xuanzhong");
                //console.log('Cal-1 clicked: ',);
            },
            today: function () {
                console.log('Cal-1 today');
            },
            nextMonth: function () {
				shuju.arr=new Array();
                var data="";
				var jishu=0;
				var shuju;
				for(var i=0;i<$(".day-contents").length;i++){
					var a=$(".day-contents")[i];
					if($(a).html()=="1"&&jishu==0){
						data=$(a).parent().attr('class').split("calendar-day-")[1].split(" calendar-dow-")[0];
						jishu++;
					}
				}
				console.log(data);
				jishu=0;
				$.ajax({ 
					url: "/professional/volunteer/tonext?data="+data+"&volunteerId="+duixiang.volunteerId,
					type: "get",
					async: false,
					success: function (json) {
						console.log(json);
						shuju=eval('(' + json + ')');
					}    
				});
					console.log(shuju.plans);
					var arr= new Array();
					$('td').each(function(){
						var td=$(this);
						td.removeClass("event");
						$(this).find("div").attr("display","none");
						var date=$(this).find("div").html();
						for(x in duixiang.plans){
							var d1=parseInt(x);
							console.log(d1);
							if(d1==date){
								duixiang.arr.push(d1);
								td.attr("data-id",duixiang.plans[x]);
							    td.addClass("event");
							}
						}						
					});
					$('.last-month').removeClass("event");
					$('.next-month').removeClass("event");
							
            },
            previousMonth: function () {
				duixiang.arr=new Array();
                var data="";
				var jishu=0;
				var shuju;
				for(var i=0;i<$(".day-contents").length;i++){
					var a=$(".day-contents")[i];
					if($(a).html()=="1"&&jishu==0){
						data=$(a).parent().attr('class').split("calendar-day-")[1].split(" calendar-dow-")[0];
						jishu++;
					}
				}
				console.log(data);
				jishu=0;
				$.ajax({ 
					url: "/professional/volunteer/tonext?data="+data+"&volunteerId="+duixiang.volunteerId,
					type: "get",
					async: false,
					success: function (json) {
						console.log(json);
						shuju=eval('(' + json + ')');
					}    
				});
					console.log(shuju.plans);
					var arr= new Array();
					$('td').each(function(){
						var td=$(this);
						td.removeClass("event");
						$(this).find("div").attr("display","none");
						var date=$(this).find("div").html();
						for(x in duixiang.plans){
							var d1=parseInt(x);
							console.log(d1);
							if(d1==date){
								duixiang.arr.push(d1);
								td.attr("data-id",duixiang.plans[x]);
							    td.addClass("event");
							}
						}						
					});
					$('.last-month').removeClass("event");
					$('.next-month').removeClass("event");
            },
            onMonthChange: function () {
                console.log('Cal-1 month changed');
            },
            nextYear: function () {
                console.log('Cal-1 next year');
            },
            previousYear: function () {
                console.log('Cal-1 previous year');
            },
            onYearChange: function () {
                console.log('Cal-1 year changed');
            },
            nextInterval: function () {
                console.log('Cal-1 next interval');
            },
            previousInterval: function () {
                console.log('Cal-1 previous interval');
            },
            onIntervalChange: function () {
                console.log('Cal-1 interval changed');
            }
        },
        multiDayEvents: {
            singleDay: 'date',
            endDate: 'endDate',
            startDate: 'startDate'
        },
        showAdjacentMonths: true,
        adjacentDaysChangeMonth: false
    });

    // Calendar 2 uses a custom length of time: 2 weeks paging 7 days
    calendars.clndr2 = $('.cal2').clndr({
        lengthOfTime: {
            days: 14,
            interval: 7
        },
        events: eventArray,
        multiDayEvents: {
            singleDay: 'date',
            endDate: 'endDate',
            startDate: 'startDate'
        },
        template: $('#template-calendar').html(),
        clickEvents: {
            click: function (target) {
                console.log('Cal-2 clicked: ', target);
            },
            nextInterval: function () {
                console.log('Cal-2 next interval');
            },
            previousInterval: function () {
                console.log('Cal-2 previous interval');
            },
            onIntervalChange: function () {
                console.log('Cal-2 interval changed');
            }
        }
    });

    // Calendar 3 renders two months at a time, paging 1 month
    calendars.clndr3 = $('.cal3').clndr({
        lengthOfTime: {
            months: 2,
            interval: 1
        },
        events: eventArray,
        multiDayEvents: {
            endDate: 'endDate',
            startDate: 'startDate'
        },
        clickEvents: {
            click: function (target) {
                console.log('Cal-3 clicked: ', target);
            },
            nextInterval: function () {
                console.log('Cal-3 next interval');
            },
            previousInterval: function () {
                console.log('Cal-3 previous interval');
            },
            onIntervalChange: function () {
                console.log('Cal-3 interval changed');
            }
        },
        template: $('#template-calendar-months').html()
    });

    // Bind all clndrs to the left and right arrow keys
    $(document).keydown( function(e) {
        // Left arrow
        if (e.keyCode == 37) {
            calendars.clndr1.back();
            calendars.clndr2.back();
            calendars.clndr3.back();
        }

        // Right arrow
        if (e.keyCode == 39) {
            calendars.clndr1.forward();
            calendars.clndr2.forward();
            calendars.clndr3.forward();
        }
    });
});