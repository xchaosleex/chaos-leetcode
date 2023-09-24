import pandas as pd


def combine_two_tables(person: pd.DataFrame, address: pd.DataFrame) -> pd.DataFrame:
    result = pd.merge(person, address, on='personId', how='left')
    result = result[['firstName', 'lastName', 'city', 'state']]
    result.fillna('Null', inplace=True)
    return result


# 示例数据
person_data = {
    'personId': [1, 2],
    'lastName': ['Wang', 'Alice'],
    'firstName': ['Allen', 'Bob']
}
address_data = {
    'addressId': [1, 2],
    'personId': [2, 3],
    'city': ['New York City', 'Leetcode'],
    'state': ['New York', 'California']
}

# 创建 DataFrame
person = pd.DataFrame(person_data)
address = pd.DataFrame(address_data)

# 调用函数并打印结果
result = combine_two_tables(person, address)
print(result)
