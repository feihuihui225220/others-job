$(function(){
	//var name=$('#J_codetext').val();
	 $(".submit_btn").click(function(){
		 submit();
  	}); 
	
})

$(function(){
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	     if(e && e.keyCode==13){ // enter 键
	    	 submit();
	    }
	}; 
	
})

function submit(){
	if(validate()){
 		$("#userLogin").submit();
	}
	return false;
	
}