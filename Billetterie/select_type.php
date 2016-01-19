<?php
if ($_GET['place'] == 'default'){
    ?>
    <option value="default" selected="selected">Type de place</option>
    <?php
}else{
    ?>
    <option value="default">Type de place</option>
<?php
}


if ($_GET['place'] == 'GrandPublic'){
?>
    <option value = "GrandPublic" selected="selected"> Grand Public </option>
    <?php
}else{
    ?>
    <option value = "GrandPublic"> Grand Public </option>
<?php
}

if ($_GET['place'] == 'Licencie'){
?>
    <option value = "Licencie" selected="selected"> Licencié </option>
    <?php
}else{
    ?>
    <option value = "Licencie"> Licencié </option>
<?php
}



if ($_GET['place'] == 'Solidarite'){
?>
    <option value = "Solidarite" selected="selected"> Solidarité </option>
    <?php
}else{
    ?>
    <option value = "Solidarite"> Solidarité </option>
<?php
}



if ($_GET['place'] == 'Promotion'){
?>
    <option value = "Promotion" selected="selected"> Promotion </option>
    <?php
}else{
    ?>
    <option value = "Promotion"> Promotion </option>
<?php
}
?>

