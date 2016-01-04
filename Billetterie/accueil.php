<?php
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
		    die('Erreur : '.$e->getMessage());
		}  
	}
	
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="style.css" type="text/css">
    </head>


    <body>
        <form method="get" action="accueil.php" id = "formulaire">
            <table>
                <tr> 
                    <td> 
                        <p>Nom : </p><input type="text" name="nom" />
                    </td> 	
                    <td rowspan=4> 
                        <img src="./images/plan_court.jpg" alt="Plan des courts"> 
                    </td>				
                    <td>
                        <p>Date : </p><input type="date" name="date_reservation" id="date_reservation" />
                    </td>			
                </tr>

                <tr> 
                    <td> 
                        <p>Prénom : </p> <input type="text" name="prenom" />
                    </td>
                    <td> 
                        <p> Court : </p>
                        <select name="court" form = "formulaire">
                        <option value = "Court1"> Court 1 </option>
                        <option value = "Court2"> Court 2 </option>
                        <option value = "Court3"> Court 3 </option>
                        <option value = "Court4"> Court 4 </option>
                        <option value = "Court5"> Court 5 </option>
                        <option value = "Court6"> Court 6 </option> 
                        </select>
                    </td>
                </tr>		


                <tr> 
                    <td>
                        <p>Date de naissance : </p> <input type="date" name="datenaiss" id="datenaiss   " />
                    </td>								
                    <td> 
                        <p> Zone : </p>
                        <select name="zone" form = "formulaire" >
                        <div id="pair"><option value = "A"> A </option></div>
                        <div id="impair"><option value = "B"> B </option></div>
                        <div id="pair"><option value = "C"> C </option></div>
                        <div id="impair"><option value = "D"> D </option></div>
                        <div id="pair"><option value = "E"> E </option></div>
                        <div id="impair"><option value = "F"> F </option></div>
                        <div id="pair"><option value = "G"> G </option></div>
                        <div id="impair"><option value = "H"> H </option></div>
                        <div id="pair"><option value = "I"> I </option></div>
                        <div id="impair"><option value = "J"> J </option></div>
                        <div id="pair"><option value = "K"> K </option></div>
                        <div id="impair"><option value = "L"> L </option></div>
                        </select>
                    </td>
                </tr>	


                <tr>	
                    <td> 
                        <p>Mail : </p><input type="email" name="mail" />
                    </td>
                    <td> 	
                        <p>Nombre de places : </p><input type="number" name="nb_places" id="nb_places" />
                    </td>

                </tr>
                <tr>
                    <td colspan="3">
                        <p>Code promo : </p><input type="text" name="code_promo"/>
                    </td>
                </tr>
            </table>
                <input type="submit" value="Calcul du prix" id="calcul" >
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
                && !empty($_GET['code_promo'])){

                    $nom = $_GET['nom'];
                    $prenom = $_GET['prenom'];	
                    $date_reservation = $_GET['date_reservation'];			
                    $mail = $_GET['mail'];
                    $zone = $_GET['zone'];
                    $court = $_GET['court'];
                    $datenaiss = $_GET['datenaiss'];
                    $nb_places = $_GET['nb_places'];
                    $code_promo = $_GET['code_promo'];

                    $bdd = Connect_db(); 
                echo $nom;;
            }
        ?>

        <a href="paiement.html"> 
            <input type="submit" value="Payer" id="redirect"> 
        </a>
    </body>
</html>
