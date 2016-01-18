<?php


$i=0;
$j=0;
$k=0;
$l=0;
$m=1;
while ($i<=8){
    while ($j<=2){
        while ($k<=5){
            while ($l<=3){
                if ($i==0) $date='2016-03-05';
                elseif ($i==1) $date='2016-03-06';
                elseif ($i==2) $date='2016-03-07';
                elseif ($i==3) $date='2016-03-08';
                elseif ($i==4) $date='2016-03-09';
                elseif ($i==5) $date='2016-03-10';
                elseif ($i==6) $date='2016-03-11';
                elseif ($i==7) $date='2016-03-12';
                elseif ($i==8) $date='2016-03-13';
                
                if ($j==0) $zone='HAUT';
                elseif ($j==1) $zone='BAS';
                elseif ($j==2) $zone='INTER';
                
                if ($k==0) $court='Court1';
                elseif($k==1) $court='Court2';
                elseif($k==2) $court='Court3';
                elseif($k==3) $court='Court4';
                elseif($k==4) $court='Court5';
                elseif($k==5) $court='Court6';
                
                if ($l==0) $type='GrandPublic';
                elseif($l==1) $type='Solidarite';
                elseif($l==2) $type='Licencie';
                elseif($l==3) $type='Promo';
                
                $stmt = "INSERT INTO `BILLETS`(`ID`, `COURT`, `DATE`, `TYPE`, `ZONE`, `DISPO`, `VENDU`, `TOTAL`) VALUES (".$m.",'".$court."','".$date."','".$type."','".$zone."',100,0,100);";
                echo $stmt;
                echo '</br>';
                $m++;
                $l++;
            }
            $l=0;
            $k++;
        }
        $k=0;
        $j++;
    }
    $j=0;
    $i++;
}
$bdd->connection = null;


?>