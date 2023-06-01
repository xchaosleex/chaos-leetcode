package main

import (
	"fmt"
)

type IniClass struct {
	IniName  string
	IniValue string
}

// main
func main() {
	// init IniClass
	var iniClass IniClass
	fmt.Println(iniClass)
}
