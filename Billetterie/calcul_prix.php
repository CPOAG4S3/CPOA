if (!empty($_GET['nom'])
                && !empty($_GET['prenom'])
                && !empty($_GET['date_reservation']) 
                && !empty($_GET['mail'])
                && !empty($_GET['court'])
                && !empty($_GET['zone'])
                && !empty($_GET['datenaiss'])
                && !empty($_GET['nb_places'])
				&& $_GET['zone'] != 'default'
				&& $_GET['court'] != 'default'){
                    
                    $bdd = Connect_db(); 
                    //S'amuser avec PHP pour tout faire marcher//
					
					// fetch type de code
					$stmt = $bdd->prepare("SELECT TYPE FROM CODE WHERE CODE = '".$code_promo."'");
					$stmt->execute();
					$type_promo="grandPublic";
					while($bddType = $stmt->fetch(PDO:: FETCH_ASSOC)){
						
						if (!empty($bddType)){
							$type_promo = $bddType['TYPE'];
						}
					}
					echo $type_promo,'</br>';
					
					// fetch coef du type
					$stmt = $bdd->prepare("SELECT COEF FROM REDUCTION WHERE PROMO = '".$type_promo."'");
					$stmt->execute();
					while($bddCodeCoef = $stmt->fetch(PDO:: FETCH_ASSOC)){
						echo $bddCodeCoef['COEF'],'</br>';
						$coef_promo = $bddCodeCoef['COEF'];
					}
					
					// promo grand public					
					
							
						//fetch  promo de la date si type = grand public
						$stmt = $bdd->prepare("SELECT COEF FROM REDUCTION_DATE WHERE DATE = '".$_GET['date_reservation']."'");
						$stmt->execute();
						while($bddDate = $stmt->fetch(PDO:: FETCH_ASSOC)){
							echo $bddDate['COEF'],'</br>';
							$coef_date = $bddDate['COEF'];
						}
						
						//fetch  promo de la zone si type = grand public
					
						$stmt = $bdd->prepare("SELECT ZONE FROM TABLE_ZONE WHERE BLOC = '".$_GET['zone']."'");
						$stmt->execute();
						while($bddZone = $stmt->fetch(PDO:: FETCH_ASSOC)){
							echo $bddZone['ZONE'],'</br>';
							$zone_bloc = $bddZone['ZONE'];
						}
						$stmt = $bdd->prepare("SELECT COEF FROM REDUCTION WHERE PROMO = '".$zone_bloc."'");
						$stmt->execute();
						while($bddZoneCoef = $stmt->fetch(PDO:: FETCH_ASSOC)){
							echo $bddZoneCoef['COEF'],'</br>';
							$zone_promo_promo = $bddZoneCoef['COEF'];
						}
						
					
					
					$prix = 50;
					if($type_promo=="grandPublic"){
						$prix = $prix * $zone_promo_promo * $coef_date;
						echo $prix;
					}	
					else{
						$prix = $prix * $zone_promo_promo * $coef_date* $coef_promo;
						echo $prix;						
					}
						
					
					
					
					
					
					
					
					
					$bdd = null;
       
            } else {
        ?>
				
                <p class="echec">Merci de remplir tous les champs avant de calculer le prix</p>
        <?php
            }