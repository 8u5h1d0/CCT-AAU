# --- generate_data_dynamic.py ---
import random
import math
from datetime import datetime, timedelta

# --- Configuration ---
# EASILY CHANGE THIS TO TEST DIFFERENT DATA SPANS
DURATION_IN_DAYS = 10

START_DATE = datetime(2023, 10, 1, 0, 0, 0)
END_DATE = START_DATE + timedelta(days=DURATION_IN_DAYS)
INTERVAL = timedelta(minutes=15)
OUTPUT_FILE = 'plant_data_percent.dat'

# --- Simulation Parameters (Unchanged) ---
WATERING_TIME_HOUR = 8
DAY_START_HOUR = 6
DAY_END_HOUR = 20
WATER_MAX_LEVEL = 100.0
WATER_MIN_LEVEL = 20.0

def calculate_light_level_percent(current_dt):
    hour = current_dt.hour + current_dt.minute / 60.0
    if DAY_START_HOUR <= hour <= 12:
        progress = (hour - DAY_START_HOUR) / (12.0 - DAY_START_HOUR)
        light_percent = progress * 100.0
    elif 12 < hour <= DAY_END_HOUR:
        progress = (DAY_END_HOUR - hour) / (DAY_END_HOUR - 12.0)
        light_percent = progress * 100.0
    else:
        light_percent = 0.0
    noise = random.uniform(-3, 3)
    return max(0, min(100, light_percent + noise))

def calculate_water_level_percent(current_dt, current_level, light_level):
    if current_dt.hour == WATERING_TIME_HOUR and current_dt.minute == 0:
        return WATER_MAX_LEVEL
    depletion_rate = 0.08
    if light_level > 10:
        depletion_rate += (light_level / 100.0) * 0.12
    new_level = current_level - depletion_rate
    noise = random.uniform(-0.5, 0.5)
    return max(WATER_MIN_LEVEL, new_level + noise)

# --- Main Generation Loop ---
print(f"Generating {DURATION_IN_DAYS} days of data...")
with open(OUTPUT_FILE, 'w') as f:
    f.write("# Timestamp(YYYY-MM-DD HH:MM:SS) WaterLevel(%) LightLevel(%)\n")
    current_time = START_DATE
    current_water = WATER_MAX_LEVEL
    while current_time <= END_DATE:
        light = calculate_light_level_percent(current_time)
        water = calculate_water_level_percent(current_time, current_water, light)
        time_str = current_time.strftime("%Y-%m-%d %H:%M:%S")
        f.write(f"{time_str} {water:.2f} {light:.2f}\n")
        current_water = water
        current_time += INTERVAL

print(f"Data generation complete. File saved as '{OUTPUT_FILE}'.")