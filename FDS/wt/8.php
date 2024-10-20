<!DOCTYPE html>
<html>
<head>
    <title>String Operations</title>
</head>
<body>
    <form method="post">
        <input type="text" name="l" placeholder="Large String" required><br><br>
        <input type="text" name="s" placeholder="Small String" required><br><br>
        <input type="number" name="n" placeholder="n Characters" required><br><br>
        <input type="submit" value="Submit">
    </form>

    <?php
        $l = $_POST['l'];
        $s = $_POST['s'];
        $n = $_POST['n'];
        echo (strpos($l, $s) === 0) ? "Small string starts the large string.<br>" : "Does not start.<br>";
        $pos = strpos($l, $s);
        echo ($pos !== false) ? "Position: $pos<br>" : "Not found.<br>";
        echo (strncasecmp($l, $s, $n) == 0) ? "First $n characters are the same.<br>" : "Different first $n characters.<br>";
    ?>
</body>
</html>
