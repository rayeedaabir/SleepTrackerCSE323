import json

# Sample data for meals
data = {
    "meals": [
        {"meal": "Breakfast", "items": [{"name": "Oatmeal", "calories": 150}, {"name": "Apple", "calories": 80}]},
        {"meal": "Lunch", "items": [{"name": "Grilled Chicken", "calories": 250}, {"name": "Rice", "calories": 200}]},
        {"meal": "Dinner", "items": [{"name": "Salad", "calories": 120}, {"name": "Soup", "calories": 100}]},
    ],
    "daily_target": 2000
}

# Write data to a JSON file
with open("preloaded_data.json", "w") as file:
    json.dump(data, file, indent=4)

print("Preloaded data written to preloaded_data.json")
