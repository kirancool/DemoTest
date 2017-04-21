    $('input[type=file]').change(function(e){
    	$(".correctupload").remove();
    	var filename=$("#csv_file")[0].files[0].name;
    	//alert($(".jfilestyle-corner").find("input").val())
       	if(filename.split(".")[1] == "csv"){
       		$("#filewrong").empty();
    		$("#executeAndSave").attr('disabled',false);	
    	}
       	else {
       		$("#filewrong").text("File should be csv");
       		$("#executeAndSave").attr('disabled',false);
       		//alert("file should be csv ")
       	}
       	
    	});
    
$('#executeAndSave').on('click',function(event){ 
		
		$("#executeAndSave").attr('disabled',true);
         var data =new FormData();
         data.append('file',$("#csv_file")[0].files[0]);
        
		 $.ajax({
			  url:"http://localhost:8080/stocks/file?filename="+$("#csv_file")[0].files[0].name,
			  type: "POST",
			  contentType:false,
			  data : data,			 
			  processData:false,
			 /* beforeSend: function(){
				  $('#loadingimgupload').append("<img src='img/lodingimg.gif' class='lodingimgupload'></img>");
	      		},*/
			  success : function(response){
				  	//alert(response);
		 		//getuploedpath(response)	
		 		
			  }
			});
		 event.preventDefault();
		
	});

