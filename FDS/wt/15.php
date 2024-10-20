<html>
<head>
    <meta charset="UTF-8">
    <title>String Operations</title>
</head>
<body>
    <h2>String Operations</h2>
    <form method="POST">
	<textarea name="ip" rows="4" cols="50" required></textarea><br>
	<input type="submit" value="Submit">
    </form>

<?php
$ip = trim($_POST['ip']);

// Perform operations
$first5 = implode(' ', array_slice(explode(' ', $ip), 0, 5));
$lc = strtolower($ip);
$tc = ucwords($lc);
$padded = "$ip";
$trimmed = ltrim($ip);
$reversed = strrev($ip);

// Display results
echo "<h3>Results:</h3>";
echo "First 5 Words: $first5<br>";
echo "Lowercase: $lc<br>";
echo "Title Case: $tc<br>";
echo "Padded String: $padded<br>";
echo "Trimmed String: $trimmed<br>";
echo "Reversed String: $reversed<br>";
?>
</body>
</html>
