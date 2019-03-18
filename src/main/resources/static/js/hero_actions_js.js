	$(document).ready(function() {
			$('#getWaterAjax').click(function() {
	            
	            $.ajax({
	                    url: 'http://localhost:8096/gathering_water',
	                    method: 'GET',

	                    headers: {
	                        'Accept': 'text/plain' 
	                    },
	                    success: function(result){
	                        console.log(result);
	                        alert(result); 
	                        
	                        $(document).ready(function() {
	                        	   var actionPoints = result.heroActionPoints;
	                        });
	                    
	                        $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
	                    }
	                });
	        });
	        
	    });
