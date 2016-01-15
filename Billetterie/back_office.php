<?php

$stmt = $bdd->prepare("INSERT INTO BILLETS (court,date,type,zone,total) VALUES (?,?,?,?,?,?,?,?)");
				$stmt->execute(array($_GET['court'],$_GET['date'],$_GET['type'],$_GET['zone'],$_GET['place']));
				
				
$stmt=$bdd->prepare("UPDATE BILLETS SET TOTAL='".$_GET['place']"'");
				$stmt->execute();
				
				
				
				
?>

<form method="GET" action="accueil.php" id = "formulaire">
                  	
              
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" min="2016-03-05" max="2016-03-13" value=<?php echo $date_reservation; ?>>
         		
                                            
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                         <?php
                            require_once("select_court.php");
                        ?>
                        </select>
						
						<p> Zone : </p>
                        <select name="zone" form = "formulaire">
                        <?php
                            require_once("select_zone.php");
                        ?>
						</select>
              

						<p> Type de place : </p>
                        <select name="place" form = "formulaire">
                        <option selected="selected" value="default"> Type de place</option>
						<option value = "GrandPublic"> Grand Public </option>
                        <option value = "Licencie"> Licencié </option>
                        <option value = "Solidarite"> Solidarité </option>
                        <option value = "promo"> Promotion </option>
                        </select>
                 
                                      
                                        
                        <p>Nombre de places : </p><input type="number" min="1" name="place" id="place" value=<?php echo $place; ?>>
         
              
                      
          
         
		 <!-- div id = calcul -->
                <div id = "calcul">
                    <input type="submit" value="Ajouter places" id="OK" >
                </div>
            </br>
        </form>
