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
		    return $bdd;
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
        <link rel="stylesheet" href="style.css" type="text/css">
        <?php
            //INITIALISATION
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
        ?>
    </head>


    <body>
        <form method="GET" action="accueil.php" id = "formulaire">
            <table>
                <tr> 
                    <td> 
                        <p>Nom : </p><input type="text" name="nom" value =<?php echo $nom; ?>>       
                    </td> 	
                    <td rowspan=4>	
                        <img src="./Images/plan_court.jpg" alt="Plan des courts">
                    </td>				
                    <td>
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" min="2016-03-05" max="2016-03-13" value=<?php echo $date_reservation; ?>>
                    </td>			
                </tr>

                <tr> 
                    <td> 
                        <p>Prénom : </p> <input type="text" name="prenom" value = <?php echo $prenom; ?>>
                    </td>
                    <td> 
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                        <?php
                            require_once("select_court.php");
                        ?>
                        </select>
                    </td>
                </tr>		


                <tr> 
                    <td>
                        <p>Date de naissance : </p> <input type="date" name="datenaiss" id="datenaiss" value=<?php echo $datenaiss; ?>>
                    </td>								
                    <td> 
                        <p> Zone : </p>
                        <select name="zone" form = "formulaire">
                        <?php
                            require_once("select_zone.php");
                        ?>
                        </select>
                    </td>
                </tr>	


                <tr>	
                    <td> 
                        <p>Mail : </p><input type="email" name="mail" value=<?php echo $mail; ?>>
                    </td>
                    <td> 	
                        <p>Nombre de places : </p><input type="number" min="1" name="nb_places" id="nb_places" value=<?php echo $nb_places; ?>>
                    </td>

                </tr>
                <tr>
                    <td colspan="3">
                        <p>Code promo : </p><input type="text" name="code_promo" value=<?php echo $code_promo; ?>>
                    </td>
                </tr>
            </table>
                <div id = "calcul">
                    <input type="submit" value="Calcul du prix" id="calcul" >
                </div>
            </br>
        </form>

        <?php
            require_once("calcul_prix.php");
        ?>

        <a href="paiement.html"> 
            <input type="submit" value="Payer" id="redirect"> 
        </a>
    </body>
</html>
