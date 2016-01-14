<?php
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
					
					// fetch type de code
					$stmt = $bdd->prepare("SELECT TYPE FROM CODE WHERE CODE = '".$code_promo."'");
					$stmt->execute();
					$type_promo="grandPublic";
					while($bddType = $stmt->fetch(PDO:: FETCH_ASSOC)){
						if (!empty($bddType)){
							$type_promo = $bddType['TYPE'];
						}
					}
					
					// fetch coef du type
					$stmt = $bdd->prepare("SELECT COEF FROM REDUCTION WHERE PROMO = '".$type_promo."'");
					$stmt->execute();
					while($bddCodeCoef = $stmt->fetch(PDO:: FETCH_ASSOC)){
						$coef_promo = $bddCodeCoef['COEF'];
					}
					
					// promo grand public					
					
				    $coef_date = 0;
                    //fetch  promo de la date si type = grand public
                    $stmt = $bdd->prepare("SELECT COEF FROM REDUCTION_DATE WHERE DATE = '".$_GET['date_reservation']."'");
                    $stmt->execute();
                    while($bddDate = $stmt->fetch(PDO:: FETCH_ASSOC)){
                        if (!empty($bddDate)){
                            $coef_date = $bddDate['COEF'];
                        }
                        
                    }

                    //fetch  promo de la zone si type = grand public

                    $stmt = $bdd->prepare("SELECT ZONE FROM TABLE_ZONE WHERE BLOC = '".$_GET['zone']."'");
                    $stmt->execute();
                    while($bddZone = $stmt->fetch(PDO:: FETCH_ASSOC)){
                        $zone_bloc = $bddZone['ZONE'];
                    }
                    $stmt = $bdd->prepare("SELECT COEF FROM REDUCTION WHERE PROMO = '".$zone_bloc."'");
                    $stmt->execute();
                    while($bddZoneCoef = $stmt->fetch(PDO:: FETCH_ASSOC)){
                        $zone_promo_promo = $bddZoneCoef['COEF'];
                    }


                $prix = 50;

                if (!empty($coef_date) && $coef_date > 0){
                    if($type_promo=="grandPublic"){
                        $prix = $prix * $zone_promo_promo * $coef_date * $_GET['nb_places'];
                        echo '<p class=\"affichage_prix\">Coût total : '.$prix.' €</p>';						
                    }	
                    else{
                        $prix = $prix * $zone_promo_promo * $coef_date * $coef_promo * $_GET['nb_places'];
                        echo '<p class=\"affichage_prix\">Coût total : '.$prix.' €</p>';						
                    }
                } else {
                    echo '<p class=\"echec\">Merci de sélectionner une date valable (entre le 5 et le 13 mars 2016)</p>';
                }	
					$bdd = null;
       
            } else {	
                echo '<p class=\"echec\">Merci de remplir tous les champs avant de calculer le prix</p>';
            }
            
            
            
?>