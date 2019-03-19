$(document).ready(function() {
			$('#getWater').click(function() {
	            
	            $.ajax({
	                    url: 'http://localhost:8096/gathering_water',
	                    method: 'GET',

	                    headers: {
	                        'Accept': 'application/json' 
	                    },
	                    success: function(result){
	                        console.log(result.message);
	                        alert(result.message); 
	                        
	                        $(document).ready(function() {
	                        	   var actionPoints = result.actionPoints;
	                        	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
	                        });
	                    
	                        
	                    }
	                });
	        });
	        
	    });

$(document).ready(function() {
	$('#getFood').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/gathering_food',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

$(document).ready(function() {
	$('#getTreasure').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/hunting_treasure',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});
	
$(document).ready(function() {
	$('#learnWelldrillingSkill').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/learning_welldrilling_skill',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

$(document).ready(function() {
	$('#learnHuntingSkill').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/learning_hunting_skill',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

$(document).ready(function() {
	$('#learnAstronomerSkill').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/learning_astronomer_skill',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

$(document).ready(function() {
	$('#learnTreasureHuntingSkill').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/learning_treasure_hunter_skill',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

$(document).ready(function() {
	$('#goingToAdvanture').click(function() {
        
        $.ajax({
                url: 'http://localhost:8096/go_to_an_adventure',
                method: 'GET',

                headers: {
                    'Accept': 'application/json' 
                },
                success: function(result){
                    console.log(result.message);
                    alert(result.message); 
                    
                    $(document).ready(function() {
                    	   var actionPoints = result.actionPoints;
                    	   $('#actionPoints').text('Akciópontok száma: ' + actionPoints);
                    });
                
                    
                }
            });
    });
    
});

