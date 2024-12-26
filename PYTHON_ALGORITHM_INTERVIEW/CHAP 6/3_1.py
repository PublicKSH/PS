#leet_code : 937
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letter_logs : List[str] = []
        digit_logs : List[str] = []
        for log_str in logs:
            if log_str.split()[1].isdigit():
                digit_logs.append(log_str)
            else:
                letter_logs.append(log_str)
        
        letter_logs.sort(key=lambda x : (x.split()[1:], x.split()[0]))
        return letter_logs + digit_logs
