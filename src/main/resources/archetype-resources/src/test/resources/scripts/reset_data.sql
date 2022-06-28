#set( $regex = "([a-z])([A-Z]+)")
#set( $replacement = "$1_$2")
#set( $tableName = $firstModel.replaceAll($regex, $replacement).toLowerCase())
DELETE FROM $tableName;