import pandas as pd
from sklearn.naive_bayes import GaussianNB

# Load dataset
df = pd.read_csv('data/heart.csv')

# Split features and target
Y = df['target']
X = df.drop(['target'], axis=1)

# Train model
model = GaussianNB()
model.fit(X, Y)

# User input
age = int(input("Enter age: "))
sex = int(input("Enter sex (0 for female, 1 for male): "))
cp = int(input("Enter cp (chest pain 0-3): "))

# Predict using DataFrame to avoid feature name warnings
input_data = pd.DataFrame([[age, sex, cp]], columns=['age', 'sex', 'cp'])
result = model.predict(input_data)

# Output prediction
if result[0] == 1:
    print("The patient is likely to have heart disease.")
else:
    print("The patient is unlikely to have heart disease.")