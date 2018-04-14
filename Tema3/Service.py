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

    firstVideoId = search_response['items'][0]['id']['videoId']

    return firstVideoId