$(function(){
	$('.input1').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var whi=$('.whiteBloodCell').val();
			var neu=$('.neutrophilicGranulocyte').val();
			var eos=$('.eosinophileGranulocyte').val();
			var bas=$('.basophileGranulocyte').val();
			var monocyte=$('.monocyte').val();
			var lymphocyte=$('.lymphocyte').val();
			var redBloodCell=$('.redBloodCell').val();
			var hemoglobin=$('.hemoglobin').val();
			var platelet=$('.platelet').val();
			var esr=$('.esr').val();
			 
			 $.ajax({
                    url: "/director/hBloodRoutine?userId="+userId+"&whiteBloodCell="+whi+"&neutrophilicGranulocyte="+neu+"&eosinophileGranulocyte="+eos+"&basophileGranulocyte="+bas+"&monocyte="+monocyte+"&lymphocyte="+lymphocyte+"&redBloodCell="+redBloodCell+"&hemoglobin="+hemoglobin+"&platelet="+platelet+"&esr="+esr+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});

	$('.input2').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var urineSpecificGravity=$('.urineSpecificGravity').val();
			var ph=$('.ph').val();
			var whiteBloodCells=$('.whiteBloodCell').val();
			var redBloodCells=$('.redBloodCell').val();
			var nitrite=$('.nitrite').val();
			var protein=$('.protein').val();
			var glucose=$('.glucose').val();
			var ketone=$('.ketone').val();
			var urinaryBladder=$('.urinaryBladder').val();
			var urineBilirubin=$('.urineBilirubin').val();
			 
			 $.ajax({
                    url: "/director/hUrineRoutine?userId="+userId+"&urineSpecificGravity="+urineSpecificGravity+"&ph="+ph+"&whiteBloodCell="+whiteBloodCells+"&redBloodCell="+redBloodCells+"&nitrite="+nitrite+"&protein="+protein+"&glucose="+glucose+"&ketone="+ketone+"&urinaryBladder="+urinaryBladder+"&urineBilirubin="+urineBilirubin+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input3').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var aptt=$('.aptt').val();
			var pt=$('.pt').val();
			var tt=$('.tt').val();
			var fg=$('.fg').val();
			var fdps=$('.fdps').val();
			var dimer=$('.dimer').val();
			 
			 $.ajax({
                    url: "/director/hDicCheck?userId="+userId+"&aptt="+aptt+"&pt="+pt+"&tt="+tt+"&fg="+fg+"&fdps="+fdps+"&dimer="+dimer+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input4').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var preAlbumin=$('.preAlbumin').val();
			var totalProtein=$('.totalProtein').val();
			var albumin=$('.albumin').val();
			var albuminRatio=$('.albuminRatio').val();
			var atl=$('.atl').val();
			var ast=$('.ast').val();
			var akp=$('.akp').val();
			var gt=$('.gt').val();
			var serumAmylase=$('.serumAmylase').val();
			var totalBilirubin=$('.totalBilirubin').val();
			var directBilirubin=$('.directBilirubin').val();
			
			 
			 $.ajax({
                    url: "/director/hLiverFunction?userId="+userId+"&preAlbumin="+preAlbumin+"&totalProtein="+totalProtein+
                    "&albumin="+albumin+"&albuminRatio="+albuminRatio+"&atl="+atl+"&ast="+ast+
                    "&akp="+akp+"&gt="+gt+"&serumAmylase="+serumAmylase+"&totalBilirubin="+totalBilirubin+
                    "&directBilirubin="+directBilirubin+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input5').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var bun=$('.bun').val();
			var cr=$('.cr').val();
			var uricAcid=$('.uricAcid').val();
			var bloodSugar=$('.bloodSugar').val();

			 
			 $.ajax({
                    url: "/director/hRenalFunction?userId="+userId+"&bun="+bun+"&cr="+cr+
                    "&uricAcid="+uricAcid+"&bloodSugar="+bloodSugar+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input6').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var potassium=$('.potassium').val();
			var sodium=$('.sodium').val();
			var chlorine=$('.chlorine').val();
			var calcium=$('.calcium').val();
			var phosphorus=$('.phosphorus').val();
			 
			 $.ajax({
                    url: "/director/hElectrolyte?userId="+userId+"&potassium="+potassium+"&sodium="+sodium+
                    "&chlorine="+chlorine+
                    "&calcium="+calcium+"&phosphorus="+phosphorus+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input7').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var ph=$('.ph').val();
			var po2=$('.po2').val();
			var pco2=$('.pco2').val();
			var standardBicarbonate=$('.standardBicarbonate').val();
			var bufferBase=$('.bufferBase').val();
			var residualAlkali=$('.residualAlkali').val();
			var oxygenSaturation=$('.oxygenSaturation').val();
			var hydrogenIonConcentration=$('.hydrogenIonConcentration').val();
			 
			 $.ajax({
                    url: "/director/hBloodGasAnalysis?userId="+userId+"&ph="+ph+"&po2="+po2+
                    "&pco2="+pco2+"&standardBicarbonate="+standardBicarbonate+
                    "&bufferBase="+bufferBase+"&residualAlkali="+residualAlkali+
                    "&oxygenSaturation="+oxygenSaturation+
                    "&hydrogenIonConcentration="+hydrogenIonConcentration+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input8').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var t3=$('.t3').val();
			var t4=$('.t4').val();
			var ft3=$('.ft3').val();
			var ft4=$('.ft4').val();
			var tsh=$('.tsh').val();
			var tgab=$('.tgab').val();
			var tpoab=$('.tpoab').val();
			var pth=$('.pth').val();
			var serumInsulin=$('.serumInsulin').val();
			var calciumReducingHormone=$('.calciumReducingHormone').val();
			 
			 $.ajax({
                    url: "/director/hHormone?userId="+userId+"&t3="+t3+"&t4="+t4+"&ft3="+ft3+
                    "&ft4="+ft4+"&tsh="+tsh+"&tgab="+tgab+
                    "&tpoab="+tpoab+"&pth="+pth+"&serumInsulin="+serumInsulin+
                    "&calciumReducingHormone="+calciumReducingHormone+
                    "&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input9').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var triglyceride=$('.triglyceride').val();
			var cholesterol=$('.cholesterol').val();
			var freeFattyAcids=$('.freeFattyAcids').val();
			var bileAcid=$('.bileAcid').val();
			var hdl=$('.hdl').val();
			var ldl=$('.ldl').val();
			var ketone=$('.ketone').val();
			var phospholipid=$('.phospholipid').val();
			 
			 $.ajax({
                    url: "/director/hBloodFat?userId="+userId+"&triglyceride="+triglyceride+
                    "&cholesterol="+cholesterol+"&freeFattyAcids="+freeFattyAcids+
                    "&bileAcid="+bileAcid+"&hdl="+hdl+"&ldl="+ldl+
                    "&ketone="+ketone+"&phospholipid="+phospholipid+
                    "&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input10').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var g=$('.g').val();
			var a=$('.a').val();
			var m=$('.m').val();
			var d=$('.d').val();
			var e=$('.e').val();
			 
			 $.ajax({
                    url: "/director/hHumoralImmunity?userId="+userId+"&g="+g+"&a="+a+"&m="+m+"&d="+d+"&e="+e+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input11').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var nk=$('.nk').val();
			var lak=$('.lak').val();
			var TCellSubsets=$('.TCellSubsets').val();
			 
			 $.ajax({
                    url: "/director/hCellularImmunity?userId="+userId+"&nk="+nk+"&lak="+lak+"&TCellSubsets="+TCellSubsets+
                    "&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	$('.input12').click(function(){
		var id=$(this).attr("date-id")
		if($('.input_compile1').attr("readonly")=="readonly"){
			$('.input_compile').removeAttr("readonly");
			$('.input_compile').addClass("input_compile2").removeClass("input_compile");
		}else{
			var userId=$('.userId').val();
			var havIgm=$('.havIgm').val();
			var hbsag=$('.hbsag').val();
			var hbsab=$('.hbsab').val();
			var hbcab=$('.hbcab').val();
			var hbeag=$('.hbeag').val();
			var hbeab=$('.hbeab').val();
			var hbv=$('.hbv').val();
			var hbvDna=$('.hbvDna').val();
			var hcvRna=$('.hcvRna').val();
			var hcv=$('.hcv').val();
			var hdv=$('.hdv').val();
			
			var hdvag=$('.hdvag').val();
			var hdvRna=$('.hdvRna').val();
			var hev=$('.hev').val();
			var hevRna=$('.hevRna').val();
			var rpr=$('.rpr').val();
			var tppa=$('.tppa').val();
			
			 
			 $.ajax({
                    url: "/director/hHepatitisVirus?userId="+userId+"&havIgm="+havIgm+"&hbsag="+hbsag+
                    "&hbsab="+hbsab+"&hbcab="+hbcab+"&hbeag="+hbeag+"&hbeab="+hbeab+
                    "&hbv="+hbv+"&hbvDna="+hbvDna+"&hcvRna="+hcvRna+"&hcv="+hcv+"&hdv="+hdv+
                    "&hdvag="+hdvag+"&hdvRna="+hdvRna+"&hev="+hev+"&hevRna="+hevRna+"&rpr="+rpr+
                    "&tppa="+tppa+"&id="+id,
                    type: "post",
                    success: function (mjson) {
                    }
            });
		
		
			$('.input_compile2').addClass("input_compile").removeClass("input_compile2");
			$('.input_compile').attr("readonly",true);
		}
	});
	
	
});


