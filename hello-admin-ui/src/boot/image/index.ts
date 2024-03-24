export const DATA_URL_IMAGE_PREFIX = "data:image/";

export function getHtmlImageElement(dataUrl: string): Promise<HTMLImageElement> {
  return new Promise((resolve, reject) => {
    const image = new Image();
    image.src = dataUrl;
    image.onload = () => resolve(image);
    image.onerror = (e) => reject(e);
  });
}
