func groupAnagrams(strs []string) [][]string {
    m := make(map[string][]string)

    for _, str := range strs {
        var count [26]int

        for _, ch := range str {
            count[ch-'a']++
        }

        // Convert array to string key
        key := fmt.Sprint(count)

        m[key] = append(m[key], str)
    }

    result := [][]string{}
    for _, group := range m {
        result = append(result, group)
    }

    return result
}