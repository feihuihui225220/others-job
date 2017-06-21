$(document).ready(function() {
    var indicator = $('.indicator');
    $('.customBtn').click(function() {

        $('.custom_Show').show();
        $('.black_overlay').show();

    })
    $('.right_close').click(function() {

        $('.custom_Show').hide();
        $('.black_overlay').hide();
        $('.dragShow .newAdd').remove();

    })
	

    $('[name="content"],[name="scale"]').click(function() {
    				
       if ($(this).is(':checked')){

            $('<li class="drag-item  newAdd" data-id=' + $(this).attr("data-id") + '>' + $(this).next().text() + '</li>').appendTo($('.dragShow')).draggable({
                revert: true,
                deltaX: 0,
                deltaY: 0
            }).droppable({
                onDragOver: function(e, source) {
                    indicator.css({
                        display: 'block',
                        left: $(this).offset().left - 10,
                        top: $(this).offset().top + $(this).outerHeight() - 5
                    });
                },
                onDragLeave: function(e, source) {
                    indicator.hide();
                },
                onDrop: function(e, source) {
                    $(source).insertAfter(this);
                    indicator.hide();
                }
            });
           
        } else {
            // 取消所选择的
            var str = $(this).attr('data-id');

                    $('.dragShow li[data-id="' + str + '"').remove();
        }

    })



    // 取消按钮
    $('.bottom_btn .cancel').click(function() {
           
            $('.custom_Show').hide();
            $('.black_overlay').hide();
        })
        // 重置按钮
    $('.bottom_btn .reset').click(function() {
            $('.dragShow .newAdd').remove();
            $('input:checkbox').each(function() {
            		$(this).attr('checked',false);
            });
			if($("li[data-id='1']").length!=1){
				$('#userID').trigger('click');
			}
			if($("li[data-id='4']").length!=1){
				$('#station').trigger('click');
			}
			$('#station').prop("checked",true);
			$('#userID').prop("checked",true);
        })

  

    // 获取焦点
    $('.searchName').focus(function() {
        $(this).val('');
    })
    $('.searchId').focus(function() {
            // alert('a');
            $('.searchId').val('');
        })
        // 失去焦点
    $('.searchName').blur(function() {
        if ($(this).val() == '')
            $(this).val('按姓名搜索');
    })
    $('.searchId').blur(function() {
        if ($(this).val() == '')
            $(this).val('按身份证号搜索');
    })

})

$(function() {
    var indicator = $('.indicator');
    $('.drag-item').draggable({
        revert: true,
        deltaX: 0,
        deltaY: 0
    }).droppable({
        onDragOver: function(e, source) {
            indicator.css({
                display: 'block',
                left: $(this).offset().left - 10,
                top: $(this).offset().top + $(this).outerHeight() - 5
            });
        },
        onDragLeave: function(e, source) {
            indicator.hide();
        },
        onDrop: function(e, source) {
            $(source).insertAfter(this);
            indicator.hide();
        }
    });
});
