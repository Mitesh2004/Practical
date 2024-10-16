<!DOCTYPE html>
<html>
    <body>
        <?php
        $temperatures = array_map(function() 
        {
            return rand(60, 85);
        },range(1, 30));
        $averageTemp = array_sum($temperatures) / count($temperatures);
        
        sort($temperatures);
        $coolestTemps = array_slice($temperatures, 0, 5); 
        $warmestTemps = array_slice($temperatures, -5, 5); 
        
        echo "<h2>Spring Weather Analysis</h2>";
        echo "<p><strong>Average High Temperature:</strong> " . round($averageTemp, 2) . "&deg;F</p>";
        echo "<p><strong>Five Coolest High Temperatures:</strong> " . implode(", ", $coolestTemps) . "&deg;F</p>";
        echo "<p><strong>Five Warmest High Temperatures:</strong> " . implode(", ", $warmestTemps) . "&deg;F</p>";
        ?>
    </body>
</html>