<?php
    ini_set('session.save_path', 'tmp');
    session_start();
    function Connect_db(){
		$host="iutdoua-webetu.univ-lyon1.fr"; 
		$user="p1405029";     
		$password="213866";     
		$dbname="p1405029";
		
		try {
		    $bdd=new PDO('mysql:host='.$host.';dbname='.$dbname.';charset=utf8',$user,$password);
		    return $bdd;                          // Connexion à la base de données
		}
		catch (Exception $e) {
		    die('Erreur : '.$e->GETMessage());
		}  
	}
	
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style.css" type="text/css">
        <?php
            //INITIALISATION des valeurs
            if (isset($_GET['nom'])){
                $nom = $_GET['nom'];
            }
            if (isset($_GET['prenom'])){
                $prenom = $_GET['prenom'];
            }
            if (isset($_GET['date_reservation'])){
                $date_reservation = $_GET['date_reservation'];
            }
            if (isset($_GET['mail'])){
                $mail = $_GET['mail'];
            }
            if (isset($_GET['zone'])){
                $zone = $_GET['zone'];
            }
            if (isset($_GET['court'])){
                $court = $_GET['court'];
            }
            if (isset($_GET['datenaiss'])){
                $datenaiss = $_GET['datenaiss'];
            }
            if (isset($_GET['nb_places'])){
                $nb_places = $_GET['nb_places'];
            }
            if (isset($_GET['code_promo'])){
                $code_promo = $_GET['code_promo'];
            }
            if (isset($_GET['payer'])){
                $code_promo = $_GET['payer'];
            }
            if (isset($_GET['reservation'])){
                $reservation = $_GET['reservation'];
            } else {
                $reservation = 'false';  
            }
            // FIN INIT //
        ?>
    </head>


    <body>
        <form method="GET" action="accueil.php" id = "formulaire">
            <table>             <!-- tableau contenant tous les inputs-->
                <tr> 
                    <td> 
                        <p>Nom : </p><input type="text" name="nom" value =<?php echo $nom; ?>>      <!-- Entrée du nom -->     
                    </td> 	
                    <td rowspan=4>	
                        <img src="./Images/plan_court.png" alt="Plan des courts">                   <!-- Plan du court -->
                    </td>				
                    <td>
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" min="2016-03-05" max="2016-03-13" value=<?php echo $date_reservation; ?>>                                                                            <!-- Entrée de la date -->
                    </td>			
                </tr>

                <tr> 
                    <td> 
                        <p>Prénom : </p> <input type="text" name="prenom" value = <?php echo $prenom; ?>>   <!-- Entrée du prénom -->
                    </td>
                    <td> 
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                        <?php
                            require_once("select_court.php");                                       // utilisation de select_court pour afficher le menu déroulant
                        ?>
                        </select>
                    </td>
                </tr>		


                <tr> 
                    <td>
                        <p>Date de naissance : </p> <input type="date" name="datenaiss" id="datenaiss" value=<?php echo $datenaiss; ?>> <!-- Entrée de la date de naissance -->
                    </td>								
                    <td> 
                        <p> Zone : </p>
                        <select name="zone" form = "formulaire">
                        <?php
                            require_once("select_zone.php");                                        // utilisation de select_zone pour afficher le menu déroulant
                        ?>
                        </select>
                    </td>
                </tr>	


                <tr>	
                    <td> 
                        <p>Mail : </p><input type="email" name="mail" value=<?php echo $mail; ?>>   <!-- Entrée du mail -->     
                    </td>
                    <td> 	
                        <p>Nombre de places : </p><input type="number" min="1" name="nb_places" id="nb_places" value=<?php echo $nb_places; ?>>
                    </td>                                                                           <!-- Entrée du nombre de places -->

                </tr>
                <tr>
                    <td colspan="3">
                        <p>Code promo : </p><input type="text" name="code_promo" value=<?php echo $code_promo; ?>>  <!-- Entrée du code promo -->
                    </td>
                </tr>
            </table>
                <div id = "calcul">
                    <input type="submit" value="Calcul du prix" id="calcul" >                   <!-- Envoi des valeurs -->
                </div>
            </br>
        </form>

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
				&& $_GET['court'] != 'default'){                                    //Si tout est entré...
                    
                    $bdd = Connect_db();                                            //on se connecte à la BD
					
					// fetch type de code
					$stmt = $bdd->prepare("SELECT TYPE FROM CODE WHERE CODE = '".$code_promo."'");
					$stmt->execute();
					$type_promo="grandPublic";                                     //Select du type de promo par rapport au code
					while($bddType = $stmt->fetch(PDO:: FETCH_ASSOC)){
						if (!empty($bddType)){
							$type_promo = $bddType['TYPE'];
						}
					}
					
					// fetch coef du type
					$stmt = $bdd->prepare("SELECT COEF FROM REDUCTION WHERE PROMO = '".$type_promo."'");
					$stmt->execute();                                              //Select du coef de ce type
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

                    //Calcul du nombre de places restantes
                    $stmt = $bdd->prepare("SELECT DISPO FROM BILLETS WHERE TYPE = '".$type_promo."' AND DATE = '".$date_reservation."' AND ZONE = '".$zone_bloc."' AND COURT = '".$court."'");
					$stmt->execute();
					while($bddNbPlaces = $stmt->fetch(PDO:: FETCH_ASSOC)){
						$nb_places_restantes = $bddNbPlaces['DISPO'];
                        echo '<p>Il reste '.$nb_places_restantes.' places correspondant à votre commande.</p>';
					}
        
                $prix = 50;                     //Définition du prix de base
                $bdd->connection = null;        //Déconnexion de la BD
                if (!empty($coef_date) && $coef_date > 0){              //Si les valeurs sont entrées
                    if($type_promo=="grandPublic"){                     //si c'est un billet grand public
                        $prix = $prix * $zone_promo_promo * $coef_date * $_GET['nb_places'];    //Le prix utilise ces coefs
                        echo '<p class="affichage_prix">Coût total : '.$prix.' €</p>';						
                    }	
                    else{                                               //sinon
                        $prix = $prix * $zone_promo_promo * $coef_date * $coef_promo * $_GET['nb_places'];  //Il vaut ce coef
                        echo '<p class="affichage_prix">Coût total : '.$prix.' €</p>';						
                    }
                } else {
                    echo '<p class="echec">Merci de sélectionner une date valable (entre le 5 et le 13 mars 2016)</p>';     //Affichage erreur
                }	
       
            } else {	
                echo '<p class="echec">Merci de remplir tous les champs avant de calculer le prix</p>';      //Affichage erreur
            }
            
            
            






    if (isset($prix) && isset($nb_places_restantes)){
        if ($nb_places<=$nb_places_restantes){
            echo'<a href=accueil.php?nom='.$nom.'&date_reservation='.$_GET['date_reservation'].'&prenom='.$_GET['prenom'].'&court='.$_GET['court'].'&datenaiss='.$_GET['datenaiss'].'&zone='.$_GET['zone'].'&mail='.$_GET['mail'].'&nb_places='.$_GET['nb_places'].'&code_promo='.$_GET['code_promo'].'&reservation=true>Réservation</a>';
        } else {
            echo '<p class="echec">Il n\'y a pas assez de places pour ces critères</p>';
        }
            
    }

        if ($reservation == 'true'){
            $bdd = Connect_db(); 
            $stmt = $bdd->prepare("SELECT DISPO 
                                    FROM BILLETS 
                                    WHERE TYPE = '".$type_promo."' 
                                    AND DATE = '".$date_reservation."' 
                                    AND ZONE = '".$zone_bloc."'");
            $stmt->execute();
            while($bddNbPlaces = $stmt->fetch(PDO:: FETCH_ASSOC)){
                $nb_places_restantes = $bddNbPlaces['DISPO'];
            }


            
            if ($nb_places<=$nb_places_restantes){
                $stmt = $bdd->prepare("UPDATE BILLETS
                                    SET VENDU = VENDU + '".$nb_places."'
                                    WHERE TYPE = '".$type_promo."' 
                                    AND DATE = '".$date_reservation."' 
                                    AND ZONE = '".$zone_bloc."'
                                    AND COURT = '".$court."'");
                $stmt->execute();
                header('Location: http://iutdoua-webetu.univ-lyon1.fr/~p1400208/CPOA/Billetterie/paiement.html');
                exit;
            } else {
                ?>
                    <p>Il n'y a pas assez de places pour ces critères.</p>
                <?php
            }
            $bdd->connection = null;
        }
        ?>
        </form>
    </body>
</html>
