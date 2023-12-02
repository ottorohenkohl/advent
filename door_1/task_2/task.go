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
	numbers := [10]string{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}

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
		defer file.Close()

		scanner := bufio.NewScanner(file)

		var result int
		for scanner.Scan() {
			result += processLine(convertLine(scanner.Text()))
		}

		return result, nil
	} else {
		return 0, err
	}
}
