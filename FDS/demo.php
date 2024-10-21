<html>
<body>
    <h2>String Operations</h2>
    <form method="POST">
        <input type="text" name="ip" placeholder="Enter a string" required><br><br>
        <input type="submit" value="Perform Operations">
    </form>

<?php
    $ip = trim($_POST['ip']);  // Get the user input and remove leading/trailing whitespaces
    
    // a. Select first 5 words from the string
    $first5Words = implode(' ', array_slice(explode(' ', $ip), 0, 5));
    
    // b. Convert the string to lowercase and then to Title case
      $lowercase = strtolower($ip);
      $titleCase = ucwords($lowercase);
    
    // c. Pad the string with "*" on both sides
    $paddedString = str_pad($ip, strlen($ip) + 4, '*', STR_PAD_BOTH);
    
    // d. Remove leading whitespaces from the string
      $trimmedString = ltrim($ip);
    
    // e. Reverse the string
      $reversedString = strrev($ip);

    // Display results
    echo "<h3>Results:</h3>";
    echo "First 5 Words: $first5Words<br>";
    echo "Lowercase to Title Case: $titleCase<br>";
    echo "Padded String: $paddedString<br>";
    echo "Trimmed String: $trimmedString<br>";
    echo "Reversed String: $reversedString<br>";
?>
</body>
</html>