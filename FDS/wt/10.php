<!DOCTYPE html>
<html>
<head>
    <title>Math Operations</title>
</head>
<body>
    <form method="post">
        <input type="number" name="num1" placeholder="First Number" required><br><br>
        <input type="number" name="num2" placeholder="Second Number" required><br><br>
        <input type="submit" name="submit" value="Calculate">
    </form>

    <?php
   
        $n1 = $_POST['num1'];
        $n2 = $_POST['num2'];

        function mod($a, $b) { return $a % $b; }
        function power($a, $b) { return $a ** $b; }
        function sum($n) { return $n * ($n + 1) / 2; }
        function factorial($n) { return $n ? $n * factorial($n - 1) : 1; }

        echo "Mod: " . mod($n1, $n2) . "<br>";
        echo "Power: " . power($n1, $n2) . "<br>";
        echo "Sum: " . sum($n1) . "<br>";
        echo "Factorial: " . factorial($n2) . "<br>";
    
    ?>
</body>
</html>
