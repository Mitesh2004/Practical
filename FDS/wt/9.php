<!DOCTYPE html>
<html>
<head>
    <title>String Manipulation</title>
</head>
<body>
    <form method="post">
        <input type="text" name="ip" placeholder="Enter a String" required><br><br>
        <select name="div" required>
            <option value="#">#</option>
            <option value="|">|</option>
            <option value="%">%</option>
        </select>
        <input type="text" name="re" placeholder="Replacement Separator" required><br><br>
        <input type="submit" value="Submit">
    </form>

    <?php
    if ($_POST) {
        $ip = $_POST['ip'];
        $div = $_POST['div'];
        $re = $_POST['re'];

        // Split the string
        $w = explode($div, $ip);
        echo "Split Words: " . implode(", ", $w) . "<br>";
        
        // Replace separator
        echo "Replaced String: " . str_replace($div, $re, $ip) . "<br>";
        
        // Last word
        echo "Last Word: " . end($w) . "<br>";
    }
    ?>
</body>
</html>
