package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
	"unicode"
)

func main() {
	if result, err := handleFile("task.txt"); err == nil {
		fmt.Println(result)
	} else {
		fmt.Println(err)
	}
}

func convertLine(line string) string {
	var numbers [10]string
	numbers[0] = "zero"
	numbers[1] = "one"
	numbers[2] = "two"
	numbers[3] = "three"
	numbers[4] = "four"
	numbers[5] = "five"
	numbers[6] = "six"
	numbers[7] = "seven"
	numbers[8] = "eight"
	numbers[9] = "nine"

	for index, number := range numbers {
		line = strings.ReplaceAll(line, number, string(number[0])+strconv.Itoa(index)+string(number[len(number)-1]))
	}

	return line
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
			fmt.Println(convertLine(scanner.Text()))
			result += processLine(convertLine(scanner.Text()))
		}

		return result, nil
	} else {
		return 0, err
	}
}
