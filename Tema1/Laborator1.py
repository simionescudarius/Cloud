from googletrans import Translator
from googleapiclient.discovery import build
import requests
import webbrowser

def callDexAntonymsAPI(word):
    antonymsFieldName = 'internalRep'

    basicApiLink = 'https://dexonline.ro/definitie-antonime/'
    endApiLink = '?format=json'
    completeApiLink = basicApiLink + word + endApiLink

    result = requests.get(completeApiLink).json()
    print("Calling DEX API...")
    print("Result recieved: ", result)
    return result['definitions'][0][antonymsFieldName]

def getFirstAntonym(words):
    return words.split('≠')[1].split(',')[0][1:]

def callGoogleTranslateAPI(word):
    translator = Translator()
    response = translator.translate(word, dest='en')
    print("Calling GoogleTranslateAPI...")
    print("Result recieved: ", response)
    return response

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

YOUTUBE_GENERIC_LINK = 'https://youtu.be/'

initialWord = 'frumos'
print("Initial word: ", initialWord, '\n')

antonym = getFirstAntonym(callDexAntonymsAPI(initialWord))
print("Extracted antonym: ", antonym, '\n')

translatedWord = callGoogleTranslateAPI(antonym).text
print("Translated word: ", translatedWord, '\n')

webbrowser.open(YOUTUBE_GENERIC_LINK + callYouTubeAPI(translatedWord))
print("Video was oppened !")