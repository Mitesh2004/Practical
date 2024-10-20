<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<form method="post" action="">
    <label>Number 1:</label>
    <input type="number" name="num1" required><br><br>
    
    <label>Number 2:</label>
    <input type="number" name="num2" required><br><br>
    
    <label>Select Operation:</label><br>
    <input type="radio" name="operation" value="add" checked> Add<br>
    <input type="radio" name="operation" value="sub"> Subtract<br>
    <input type="radio" name="operation" value="mul"> Multiply<br>
    <input type="radio" name="operation" value="div"> Divide<br><br>
    
    <input type="submit" name="submit" value="Calculate">
</form>

<?php
if (isset($_POST['submit'])) {
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];
    $operation = $_POST['operation'];


    function calculate($num1 = 0, $num2 = 1, $operation = 'add') {
        switch ($operation) {
            case 'add':
                return $num1 + $num2;
            case 'sub':
                return $num1 - $num2;
            case 'mul':
                return $num1 * $num2;
            case 'div':
                return ($num2 != 0) ? $num1 / $num2 : 'Cannot divide by zero';
        }
    }
    
    $result = calculate($num1, $num2, $operation);
    echo "<h3>Result: $result</h3>";
}
?>

</body>
</html>
