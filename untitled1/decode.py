def decode(message_file):
    with open(message_file, 'r') as file:
        lines = file.readlines()
    decoded_words = []
    lines.sort(key=lambda x: int(x.split()[0]))
    expected_number = 1
    # i = 1
    for line in lines:
        parts = line.split()
        number = int(parts[0])

        word = parts[1]
        if number == expected_number:
            print(number, word)
            decoded_words.append(word)
            expected_number += len(decoded_words) + 1
    decoded_message = ' '.join(decoded_words)
    return decoded_message


decoded_message = decode('coding_qual_input.txt')
print(decoded_message)
