package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"unicode"
)

func main() {
	if result, err := handleFile("task.txt"); err == nil {
		fmt.Println(result)
	} else {
		fmt.Println(err)
	}
}

func processLine(line string) int {
	var f, s int32 = -1, -1
	for _, c := range line {
		if unicode.IsDigit(c) {
			if f == -1 {
				f, s = c, c
			} else {
				s = c
			}
		}
	}

	r, _ := strconv.Atoi(string(f) + string(s))
	return r
}

func handleFile(path string) (int, error) {
	if file, err := os.Open(path); err == nil {
		defer func(file *os.File) {
			_ = file.Close()
		}(file)

		scanner := bufio.NewScanner(file)
		result := 0

		for scanner.Scan() {
			result += processLine(scanner.Text())
		}

		return result, nil
	} else {
		return 0, err
	}
}
