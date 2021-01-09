from setuptools import setup, find_packages
 
classifiers = [
  'Development Status :: 5 - Production/Stable',
  'Intended Audience :: Professional',
  'Operating System :: Linux :: Manjaro-Linux :: Xfce 4.14',
  'License :: OSI Approved :: MIT License',
  'Programming Language :: Python :: 3'
]
 
setup(
  name='encryptit',
  version='0.0.1',
  description='A route cipher based cryptography algorithm',
  long_description=open('README.txt').read() + '\n\n' + open('CHANGELOG.txt').read(),
  url='',  
  author='Ravi Prakash',
  author_email='1907prakash.ravi@gmail.com',
  license='MIT', 
  classifiers=classifiers,
  keywords='encryption, decryption, cryptography', 
  packages=find_packages(),
  install_requires=[''] 
)