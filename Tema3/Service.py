from googleapiclient.discovery import build
from tkinter import *
from google.cloud import translate
import requests
import webbrowser
import os
from uuid import getnode as get_mac
import json

os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "C:\Faculty\Cloud\Cloud\Tema3\keys\TranslateKey.json"
YOUTUBE_GENERIC_LINK = 'https://youtu.be/'
GOOGLE_LINK = 'https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDrVaucbPT7tYFvI7de637CcA9eY72gMaI'

def callGoogleTranslateAPI(text, target):
    translateClient = translate.Client()
    translation = translateClient.translate(text, target_language=target)
    return translation['translatedText']

def callYouTubeAPI(word):
    DEVELOPER_KEY = 'AIzaSyAUZhK4aXT7XKMw0Ncx6MUoJ5iRG6OZRt4'
    YOUTUBE_API_SERVICE_NAME = 'youtube'
    YOUTUBE_API_VERSION = 'v3'

    youtube = build(YOUTUBE_API_SERVICE_NAME, YOUTUBE_API_VERSION,
                    developerKey=DEVELOPER_KEY)

    search_response = youtube.search().list(
        q=word,
        part='id,snippet',
        maxResults=1
    ).execute()

    print("Calling YouTubeAPI...")
    print(search_response, '\n')
    firstVideoId = search_response['items'][0]['id']['videoId']

    return firstVideoId

def buildJsonForGoogleMapsApi():
    pass

#initialWord = 'frumos'
#print("Initial word: ", initialWord, '\n')

#antonym = getFirstAntonym(callDexAntonymsAPI(initialWord))
#print("Extracted antonym: ", antonym, '\n')

#translatedWord = callGoogleTranslateAPI("mancare", "en")
#print("Translated word: ", translatedWord, '\n')

#webbrowser.open(YOUTUBE_GENERIC_LINK + callYouTubeAPI(translatedWord))
#print("Video was oppened !")

mac = get_mac()
print(mac)

root = Tk()
root.geometry('1200x800')

def onTranslateButton(event):
    text = translateText.get()
    translated = callGoogleTranslateAPI(text, 'en')
    translatedText.set(translated)


#TRANSLATE
Label(root, text="GOOGLE TRANSLATE").grid(row = 0, column = 1)
translateText = Entry(root)
translateText.grid(row=1, column=0, padx = 5, pady = 10)
translateButton = Button(root, text='Translate')
translateButton.grid(row=2, column=1)
translateButton.bind('<Button-1>', onTranslateButton)
Label(root, text="RO -> EN").grid(row=1, column=1)
translatedText = Entry(root)
translatedText.grid(row = 1, column = 2)

#YOUTUBE
Label(root, text="YOUTUBE VIDEO").grid(row = 3, column = 1, pady = 30)
Label(root, text="NAME: ").grid(row = 4, column = 0)
videoNameToSearch = Entry(root)
videoNameToSearch.grid(row = 4, column = 1)
searchButton = Button(root, text='Search')
searchButton.grid(row = 4, column = 2)
Label(root, text="->").grid(row=4, column=3)
searchResult = Label(root, text = "resultLink")
searchResult.grid(row = 4, column = 4)


root.mainloop()