func groupAnagrams(strs []string) [][]string {
    m := make(map[[26]int][]string)

    for _, str := range strs {
        var count [26]int

        for _, ch := range str {
            count[ch-'a']++
        }

        m[count] = append(m[count], str)
    }

    result := [][]string{}
    for _, group := range m {
        result = append(result, group)
    }

    return result
}