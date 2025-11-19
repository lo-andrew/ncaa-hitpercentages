from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from bs4 import BeautifulSoup
import pandas as pd
import time

url = "https://www.ncaa.com/stats/volleyball-men/d1/current/individual/520"
url2 = "https://www.ncaa.com/stats/volleyball-men/d1/current/individual/520/p2"

options = webdriver.ChromeOptions()
options.add_argument('--headless')
options.add_argument('--no-sandbox')
options.add_argument('--disable-dev-shm-usage')
options.add_argument('user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36')

driver = webdriver.Chrome(options)

driver.get(url)
time.sleep(3) 

WebDriverWait(driver, 20).until(
    EC.presence_of_element_located((By.CSS_SELECTOR, "tbody tr"))
)

soup = BeautifulSoup(driver.page_source, "html.parser")
table = soup.find("table")

headers = [th.get_text() for th in table.find("thead").find_all("th")]

data = []
for row in table.find("tbody").find_all("tr"):
    cols = [td.get_text() for td in row.find_all("td")]
    if cols:
        data.append(cols)

df = pd.DataFrame(data, columns=headers)
df.to_csv("ncaa_stats_trial.csv", index=False)
print(f"scraped {len(df)} rows!")

driver.quit()